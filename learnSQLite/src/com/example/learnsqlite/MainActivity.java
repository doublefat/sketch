package com.example.learnsqlite;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {

	private MySQLiteHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper=new MySQLiteHelper(this);
		
		initBehavior();
	}

	private void initBehavior() {
		
		setCreateDeleteBtText();
	}

	private void setCreateDeleteBtText() {
		
		Button bt=(Button) this.findViewById(R.id.table_op_bt);
		if(isTableExistent("test1")){
			bt.setText("Delete Table");
		}
		else{
			bt.setText("Create Table");
		}
		
	}

	private boolean isTableExistent(String table) {
		// TODO Auto-generated method stub
		return dbHelper.isTableExistent(table);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
