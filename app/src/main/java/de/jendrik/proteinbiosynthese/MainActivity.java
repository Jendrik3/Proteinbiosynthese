package de.jendrik.proteinbiosynthese;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private ViewGroup             contentPane;
	private String[]              navitems;
	private DrawerLayout          drawerLayout;
	private Toolbar               toolbar;
	private ActionBarDrawerToggle drawerToggle;
	private Fragment[] fragments = {new MainFragment(), new CodesonneFragment()};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//setTheme(R.style.AppTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		disableKeyboard();

		contentPane = (ViewGroup) findViewById(R.id.content_pane);
		navitems = getResources().getStringArray(R.array.navitems);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		final ListView drawerList = (ListView) findViewById(R.id.drawer_list);
		drawerList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, navitems));
		drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
				contentPane.removeAllViews();

				final Fragment f = fragments[position];
				//getSupportFragmentManager().beginTransaction().disallowAddToBackStack().commit();

				if (f != null) {
					toolbar.setTitle(navitems[position]);
					getSupportFragmentManager()
							.beginTransaction()
							.replace(R.id.content_pane, f)
							.commit();
				}
				drawerLayout.closeDrawers();
			}
		});

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.empty, R.string.empty);
		drawerLayout.setDrawerListener(drawerToggle);

		final ViewGroup contentPane = (ViewGroup) findViewById(R.id.content_pane);
		contentPane.addView(getLayoutInflater().inflate(R.layout.fragment_main, null));

		final ActionBar actionbar = getSupportActionBar();
//		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setDisplayShowTitleEnabled(true);
		actionbar.setDefaultDisplayHomeAsUpEnabled(true);
		actionbar.setShowHideAnimationEnabled(true);

	}

	private void disableKeyboard() {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
			final View activityRootView = findViewById(R.id.root);
			activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				@Override
				public void onGlobalLayout() {
					Rect r = new Rect();
					//r will be populated with the coordinates of your view that area still visible.
					activityRootView.getWindowVisibleDisplayFrame(r);

					int heightDiff = activityRootView.getRootView().getHeight() - (r.bottom - r.top);
					if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
						//Hide the keyboard instantly!
						if (getCurrentFocus() != null) {
							InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
							imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
						}
					}
				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item))
			return true;

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onPostCreate(final Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(final Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}
}
