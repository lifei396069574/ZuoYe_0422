package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.fragment_0422.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bean.Bean;
import utils.HttpUtils;
import utils.MyUri;

/**
 * 作者：李飞 on 2017/4/22 10:55
 * 类的用途：
 */

public class RightFragment extends Fragment {


    private TextView text_name;
    private TextView text_price;
    private ImageView image;
    private List<Bean.DatalistBean> mList;
    private TextView text_name2;
    private TextView text_price2;
    private ImageView image2;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            mList = (List<Bean.DatalistBean>) msg.obj;

        }
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.right, null);

        initView(v);

        getData();

        return v;
    }

    //设置数据
    public void setData(final int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            Bean.DatalistBean datalistBean = mList.get(arr[i]);
            Log.i("zzz",arr[i]+"");
            if (i==0){
                text_name.setText(datalistBean.getCourse_name());
                text_price.setText(datalistBean.getCourse_tname());
                ImageLoader.getInstance().displayImage(datalistBean.getCourse_pic(), image);
            }else {
                text_name2.setText(datalistBean.getCourse_name());
                text_price2.setText(datalistBean.getCourse_tname());
                ImageLoader.getInstance().displayImage(datalistBean.getCourse_pic(), image2);
            }

        }

    }

    private void initView(View v) {
        text_name = (TextView) v.findViewById(R.id.text_name);
        text_price = (TextView) v.findViewById(R.id.text_price);
        image = (ImageView) v.findViewById(R.id.image);
        text_name2 = (TextView) v.findViewById(R.id.text_name2);
        text_price2 = (TextView) v.findViewById(R.id.text_price2);
        image2 = (ImageView) v.findViewById(R.id.image2);

    }


    public void getData() {
        new Thread() {
            @Override
            public void run() {
                super.run();

                String json = new HttpUtils(MyUri.url).getHttpContunt();

                Gson gson = new Gson();

                Bean bean = gson.fromJson(json, Bean.class);

                List<Bean.DatalistBean> datalist = bean.getDatalist();

                Message message = Message.obtain();
                message.obj = datalist;

                mHandler.sendMessage(message);


            }
        }.start();
    }
}
