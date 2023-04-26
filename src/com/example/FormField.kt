class FormField(context: Context, attributeSet: AttributeSet) :
    RelativeLayout(context, attributeSet)
{

    private var labelTop: TextView
    private var helperBottom: TextView
    private var userInput: EditText

    init {
        inflate(context, R.layout.form_field, this)

        val attrArray: TypedArray =
            context.ontainStyledAttributes(attributeSet, R.styleable.FormField)
        val labelTopString = attrArray.getString(R.styleable.FormField_labelTop)
        val helperBottomString = attrArray.getString(R.styleable.FormField_helperBottomText)
        val iconEnd = attrArray.getInt(R.styleable.FormField_iconEnd, 0) // def value = 0
        attrArray.recycle()

        labelTop = findViewById(R.id.label_top)
        helperBottom = findViewById(R.id.helper_bottom_text)
        userInput = findViewById(R.id.input_edit_text)

        labelTop.text = labelTopString

        if (!helperBottomString.isNullOrBlank()) {
            helperBottom.text = helperBottomString
            helperBottom.visibility = VISIBLE
        }

        if (iconEnd != 0) {
            userInput.setCompoundDrawablesWithIntrinsicBounds(
                null, null,
                ContextCompat.getDrawable(context, iconEnd),
                null
            )
        }

        userInput.addTextChangedListener {
            // something idk tbh
            object : TextWatcher {}
        }
    }

    fun setErrorState(helperBottomString: String) {
        helperBottom.text = helperBottomString
        helperBottom.visibility = VISIBLE
        userInput.background =
            ContextCompat.getDrawable(context, R.drawable.form_field_border_error)
    }

    fun setDisableState() {
        helperBottom.visibility = GONE
        userInput.isEnabled = false
        userInput.background =
            ContextCompat.getDrawable(context, R.drawable.form_field_border)
    }

    fun setDefaultState() {
        helperBottom.visibility = GONE
        userInput.isEnabled = true
        userInput.background =
            ContextCompat.getDrawable(context, R.drawable.form_field_border)
    }
}