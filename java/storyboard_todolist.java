// (new) - (fragments) - (blank fragments ) 생성 후 이 부분만 변경해주면 됩니다. 
public class storyboard_todolist extends Fragment{
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_storyboard_todolist, container, false);

        return rootView;
    }
}


