package com.mobilecomp.viswa.a3_phd18010;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuizFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    private RecyclerView mQuizRecyclerView;
    List<Questions> quesList;
    int qid = 0;
    Questions currentQues;
    int quesID;
    String textQuestion;
    Boolean choice;
    Button bQuestion;

    private OnFragmentInteractionListener mListener;


    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        mQuizRecyclerView = (RecyclerView) view.findViewById(R.id.quiz_recycler_view);
        //To be removed
        //Questions questions[] = {new Questions("Q1"),new Questions("Q2")};

        QuizHelper quizHelper = new QuizHelper(getContext());
        quesList = quizHelper.getAllQuestions();
        currentQues = quesList.get(qid);




        mQuizRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // 3. create an adapter
        QuizAdapter qAdapter = new QuizAdapter(quesList);
        // 4. set adapter
        mQuizRecyclerView.setAdapter(qAdapter);
        // 5. set item animator to DefaultAnimator
        mQuizRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
    public static class QuizHolder extends RecyclerView.ViewHolder {

        public Button qButton;

        public QuizHolder(View itemLayoutView) {
            super(itemLayoutView);
            qButton = (Button) itemLayoutView.findViewById(R.id.Question);

        }
    }

    public class QuizAdapter extends RecyclerView.Adapter<QuizHolder>{
        private List<Questions> questions;
        public QuizAdapter(List<Questions> questions) {
            this.questions = questions;
        }
        public QuizHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_layout, null);

            // create ViewHolder

            QuizHolder viewHolder = new QuizHolder(itemLayoutView);
            return viewHolder;
        }

        public void onBindViewHolder(final QuizHolder viewHolder, final int position) {

            // - get data from your itemsData at this position
            // - replace the contents of the view with that itemsData



            viewHolder.qButton.setText(Integer.toString(questions.get(position).getID()));



            textQuestion = questions.get(position).getQuestion();
            quesID = questions.get(position).getID();
            //Toast.makeText(getView().getContext(),textQuestion,Toast.LENGTH_SHORT).show();
            bQuestion = viewHolder.qButton;
            bQuestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String item = questions.get(position).getQuestion();
                    int quesID = questions.get(position).getID();

                    Toast.makeText(getContext(),Integer.toString(quesID) , Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    Bundle b = new Bundle();

                    b.putString("question", item);
                    b.putInt("qID",quesID);
                    intent.putExtras(b);
                    startActivity(intent);
                }
            });







        }

        public int getItemCount() {
            return questions.size();
        }



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
