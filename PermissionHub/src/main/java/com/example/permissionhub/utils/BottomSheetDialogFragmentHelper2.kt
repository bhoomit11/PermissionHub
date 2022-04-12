package com.example.permissionhub.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialogFragmentHelper<B : ViewDataBinding> : BottomSheetDialogFragment() {

    var viewCreatedCallback: ((binding: B, dialogFragment: BottomSheetDialogFragment) -> Unit)? =
        null
    var onStartCallback: ((bottomSheetDialogFragment: BottomSheetDialogFragment) -> Unit)? = null
    var onCreateCallback: ((bottomSheetDialogFragment: BottomSheetDialogFragment) -> Unit)? = null

    companion object {
        fun <B : ViewDataBinding> with(
            layout: Int,
            isAnimationRequire: Boolean = true,
            isCancellable: Boolean = true,
            isCancellableOnTouchOutSide: Boolean = true,
            onStartCallback: ((bottomSheetDialogFragment: BottomSheetDialogFragment) -> Unit)? = null,
            onCreateCallback: ((bottomSheetDialogFragment: BottomSheetDialogFragment) -> Unit)? = null,
            viewCreatedCallback: (binding: B, dialogFragment: BottomSheetDialogFragment) -> Unit
        ): androidx.fragment.app.DialogFragment {
            val dialog = BottomSheetDialogFragmentHelper<B>().apply {
                arguments = Bundle().apply {
                    putInt("RES", layout)
                    putBoolean("IS_CANCELLABLE", isCancellable)
                    putBoolean("IS_CANCELLABLE_ON_TOUCH_OUTSIDE", isCancellableOnTouchOutSide)
                    putBoolean("IS_ANIMATION_REQUIRE", isAnimationRequire)
                }
            }
            dialog.isCancelable = isCancellable
            dialog.viewCreatedCallback = viewCreatedCallback
            dialog.onStartCallback = onStartCallback
            dialog.onCreateCallback = onCreateCallback
            return dialog
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog, style: Int) {
        val bottomSheetDialog = dialog as BottomSheetDialog
        bottomSheetDialog.setContentView(arguments?.getInt("RES") ?: -1)

        try {
            val behaviorField = bottomSheetDialog.javaClass.getDeclaredField("behavior")
            behaviorField.isAccessible = true
            val behavior = behaviorField.get(bottomSheetDialog) as BottomSheetBehavior<*>?
            behavior?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {


                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                        behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {

                }
            })
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(arguments?.getInt("RES") ?: -1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewCreatedCallback?.invoke(DataBindingUtil.bind<B>(view)!!, this)
        if (viewCreatedCallback == null) {
            dismiss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogThemeNoFloating)
        onCreateCallback?.invoke(this)
    }

    override fun onStart() {
        super.onStart()
        if (view?.parent != null)
            (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)
        onStartCallback?.invoke(this)
    }
}