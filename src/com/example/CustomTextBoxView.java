// Import yo shit

public class CustomTextBoxView extends LinearLayout {
    private TextView m_label;
    private EditText m_textBox;
    private ImageView m_optionBtn;

    public CustomTextBoxView (Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.CustomTextBox, 0, 0); // stylable name from attrs.xml

        // Get attrs with arg in format R.styleable.[STYLEABLE_NAME]_[ATTR_NAME]
        String label = ta.getString(R.styleable.CustomTextBox_customLabel);
        String placeholder = ta.getString(R.styleable.CustomTextBox_customPlaceholder);
        int imgSrc = ta.getInt(R.styleable.CustomTextBox_customSrc);

        ta.recycle();

        // Use LayoutInflater to overwrite xml file over current blank View
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_text_box, this, true);

        // Find elements from xmls
        m_label = (TextView) this.getChildAt(0);
        m_textBox = (EditText) this.getChildAt(1);
        m_optionBtn = (ImageView) this.getChildAt(2);

        // Set element props
        m_label.setText(label);
        m_textBox.setHint(placeholder);
        m_optionBtn.setImageResource(imgSrc);
    }

    public CustomTextBoxView(Context context) {
        this(context, null);
    }

    public void customFunction1() {
        // do something
    }

    public boolean customFunction2(int arg1) {
        // do something

        return false;
    }
}