package com.example.test7;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private ListView lv;
	
	private List<TextView> list;
	
	private int count;
	
	private MyAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<TextView>();
        count = list.size();
        
        lv = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter();
        lv.setAdapter(adapter);
    }
    
    public void add(View view){
    	TextView tv = new TextView(getApplicationContext());
    	tv.setText("Friend" + count++);
    	tv.setTextColor(Color.BLUE);
    	tv.setTextSize(26);
    	list.add(tv);
    	adapter.notifyDataSetChanged();
    }
    
    public void remove(View view){
    	list.remove(count-1);
    	adapter.notifyDataSetChanged();
    }
    
    class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			TextView tv = list.get(position);
			return tv;
		}
    	
    }

}
