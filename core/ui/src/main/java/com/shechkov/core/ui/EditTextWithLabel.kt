package com.shechkov.core.ui

import android.content.Context
import android.os.Parcelable
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.shechkov.core.ui.databinding.ViewEditTextWithLabelBinding

class EditTextWithLabel @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewEditTextWithLabelBinding = ViewEditTextWithLabelBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        initAttributes()
    }

    private fun initAttributes(
    ) {
        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.EditTextWithLabel)

            hint(a.getString(R.styleable.EditTextWithLabel_hint) ?: "")
            title(a.getString(R.styleable.EditTextWithLabel_title) ?: "")

            inputType(
                a.getInt(
                    R.styleable.EditTextWithLabel_android_inputType,
                    EditorInfo.TYPE_CLASS_TEXT
                )
            )


            a.recycle()
        }
    }

    fun inputType(type: Int) {
        binding.editText.inputType = type
    }

    fun title(title: String) {
        binding.titleTextView.text = title
    }

    fun setFilters(filters: Array<InputFilter>) {
        binding.editText.filters = filters
    }

    fun error(message: String) {
        binding.errorText.apply {
            //isVisible = message.isNotEmpty()
            text = message
        }
    }

    fun hint(hint: String) {
        binding.editText.hint = hint
    }

    fun hint(hint: Int) {
        binding.editText.setHint(hint)
    }

    fun editText() = binding.editText

    fun clear() {
        binding.editText.setText("")
        error("")
    }

    class EditTextChangeListener(private val action: (String) -> Unit) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            action(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

    private var editTextChangeListener = ArrayList<TextWatcher>()

    fun addListener(action: (String) -> Unit) {
        editTextChangeListener.add(EditTextChangeListener(action))
        binding.editText.addTextChangedListener(editTextChangeListener[0])
    }

    fun removeListener() {
        if (editTextChangeListener.isEmpty())
            return

        binding.editText.removeTextChangedListener(editTextChangeListener[0])
        editTextChangeListener.clear()
    }

    fun text() = binding.editText.text.toString()


}