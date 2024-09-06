package com.samirislamic.doaa._01_common._02_base.fragment

import android.os.Bundle
import com.samirislamic.doaa._01_common._02_base.BaseViewModel

/**
 * Abstract class to handle ViewModel initialization and lifecycle.
 * @param VM The type of ViewModel associated with the fragment.
 */
abstract class ViewModelHandlerFragment<VM : BaseViewModel>(protected var baseViewModel: VM) : BackPressedHandlerFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
        baseViewModel.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        baseViewModel.stop()
    }

    /**
     * Initializes the ViewModel associated with the fragment.
     * Subclasses must override this method to initialize the ViewModel.
     */
    protected abstract fun initializeViewModel()
}
