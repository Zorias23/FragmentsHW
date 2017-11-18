package com.example.admin.fragmentshw.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.fragmentshw.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CelebrityInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CelebrityInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebrityInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String KOBE_BRYANT_INFO = "Kobe Bryant is an all-star hall of fame player who won 5 championships with the Lakers" +
            "and spent his entire 20+ year career with the Los Angeles Lakers.  His side-kick was Shaquille O'neil. He was unstoppable at the " +
            "guard position";
    public static final String KAWAI_LEONARD_INFO = "Kawaii Leonard is the star player on the San Antonio Spurs.  He is considered the best two" +
            "way player in the NBA, which means he has great defense as well as offense.  He has also won defensive player of the year two years" +
            "in a row.  He is one of the elite players at his small forward position.";
    public static final String MANU_GINOBLI_INFO = "Manu Ginobli will surely be a hall of fame player whenever he retires.  He has had an illustrious" +
            "career on the San Antonio Spurs.  His finesse style and patented euro-stop has eluded those who try to guard him for 10+ years on the " +
            "Spurs.  He is a spectacular threat in the shooting guard position";
    public static final String TIM_DUNCAN_INFO = "Tim Duncan will be a hall of fame player when he retires.  He has played his entire 15+ year career" +
            "on the San Antonio Spurs. His initial side-kick was David Robinson, but as time went on, his side-kicks were Manu Ginobli and Tony" +
            "Parker.  He retired last year.  While playing, he was one of the most dominant players at the center position in the NBA.";
    public static final String GREGG_POPPOVICH_INFO  = "Gregg Poppovich is the longtime coach for the San Antonio Spurs.  He will surely be in" +
            "the hall of fame as one of the greatest coaches ever whenever he retires.  He is an excellent coach who is quite possibly the " +
            "best coach when it comes down to late game execution for a close game.  He is a great man.  I wish I was him sometimes.";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvCelebrityName;
    private TextView tvCelebrityInfo;
    private ImageView celebrityPhoto;

    private OnFragmentInteractionListener mListener;

    public CelebrityInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CelebrityInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebrityInfoFragment newInstance(String param1, String param2) {
        CelebrityInfoFragment fragment = new CelebrityInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_info, container, false);
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
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        } */
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
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCelebrityName = view.findViewById(R.id.celebrityName);
        tvCelebrityInfo = view.findViewById(R.id.celebrityDescription);
        celebrityPhoto = view.findViewById(R.id.celebrityImage);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvCelebrityName.setText(mParam1);
        String name = mParam1;
        switch (name) {
            case "Kobe Bryant":
                tvCelebrityInfo.setText(KOBE_BRYANT_INFO);
                celebrityPhoto.setImageResource(R.drawable.kobe_bryant);
                break;
            case "Manu Ginobli":
                tvCelebrityInfo.setText(MANU_GINOBLI_INFO);
                celebrityPhoto.setImageResource(R.drawable.manu_ginobli);
                break;
            case "Greg Poppovich":
                tvCelebrityInfo.setText(GREGG_POPPOVICH_INFO);
                celebrityPhoto.setImageResource(R.drawable.gregg_poppovich);
                break;
            case "Kawaii Leanord":
                tvCelebrityInfo.setText(KAWAI_LEONARD_INFO);
                celebrityPhoto.setImageResource(R.drawable.kawai_leonard);
                break;
            case "Tim Duncan":
                tvCelebrityInfo.setText(TIM_DUNCAN_INFO);
                celebrityPhoto.setImageResource(R.drawable.tim_duncan);
                break;

        }

    }
}
