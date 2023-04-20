// Import yo shit

// Note that this will be using {@link using_custom_text_box.xml}
public class UserLoginFragment extends Fragment {
    ...

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        CustomTextBoxView customtb = (CustomTextBoxView) v.findViewById(R.id.customTextBox);

        customtb.customFunction1();
        customtb.customFunction2(100);
    }
}