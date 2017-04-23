package fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.fragment_0422.MainActivity;
import com.example.administrator.fragment_0422.R;

/**
 * 作者：李飞 on 2017/4/22 10:54
 * 类的用途：
 */

public class LeftFragment extends Fragment {
    private String[] datas=new String[]{"条目 0  1 ","条目 2  3 ","条目 4  5 ","条目 6  7 ","条目 8  9 "};
    private int arr[][] = new int[][]{{0,1},{2,3},{4,5},{6,7},{8,9}};
    private MainActivity context;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        context=(MainActivity)activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.left, null);

        ListView lv=(ListView) v.findViewById(R.id.listView1);

        //创建适配器
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,datas);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                FragmentManager manager = context.getSupportFragmentManager();

                RightFragment right=(RightFragment) manager.findFragmentByTag("right");

                right.setData(arr[position]);
            }
        });

        return v;
    }

}
