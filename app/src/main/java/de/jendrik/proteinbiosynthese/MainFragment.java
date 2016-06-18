package de.jendrik.proteinbiosynthese;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.common.base.Splitter;
import de.jendrik.proteinbiosynthese.aminosäure.Aminosäure;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

	private EditText dnaET;
	private EditText mrnaET;
	private EditText tripletsET;
	private final List<Aminosäure> triplets    = new ArrayList<>();
	@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
	private final CodeSonneMap     codeSonne   = new CodeSonneMap();

	@Nullable @Override
	public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
		final ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);

		root.findViewById(R.id.btn_a)
		    .setOnClickListener(add);
		root.findViewById(R.id.btn_t).setOnClickListener(add);
		root.findViewById(R.id.btn_g).setOnClickListener(add);
		root.findViewById(R.id.btn_c).setOnClickListener(add);
		root.findViewById(R.id.btn_back).setOnClickListener(remove);

		final LinearLayout.LayoutParams tripletsLP = (LinearLayout.LayoutParams) root.findViewById(R.id.tripletsTV).getLayoutParams();
		root.findViewById(R.id.dnaTV).setLayoutParams(tripletsLP);
		root.findViewById(R.id.mrnaTV).setLayoutParams(tripletsLP);
		dnaET = (EditText) root.findViewById(R.id.dnaET);
		mrnaET = (EditText) root.findViewById(R.id.mrnaET);
		tripletsET = (EditText) root.findViewById(R.id.tripletsET);

		dnaET.addTextChangedListener(new TextAdapter() {
			@Override
			public void afterTextChanged(final Editable s) {
				final StringBuilder mrna = new StringBuilder(s.length());
				for (char c : s.toString().toCharArray()) {
					switch (c) {
						case 'A':
							mrna.append("U");
							break;
						case 'T':
							mrna.append("A");
							break;
						case 'C':
							mrna.append("G");
							break;
						case 'G':
							mrna.append("C");
							break;
						default:
							throw new IllegalStateException("Invalid character");
					}
				}
				mrnaET.setText(mrna);
				final List<String> strings = Splitter.fixedLength(3).omitEmptyStrings().splitToList(mrna);
				triplets.clear();
				for (String triplet : strings) {
					if (triplet.length() == 3) {
						triplets.add(codeSonne.get(triplet.toUpperCase()));
					}
				}
				final String newText = TextUtils.join("-", triplets);
				tripletsET.setText(newText);
			}

		});
		return root;
	}

	private View.OnClickListener add = new View.OnClickListener() {
		@Override
		public void onClick(final View v) {
			if (dnaET.hasFocus()) {
				final Button btn = (Button) v;
				dnaET.append(btn.getText());
			}
		}
	};

	private View.OnClickListener remove = new View.OnClickListener() {
		@Override
		public void onClick(final View v) {
			if (dnaET.hasFocus()) {
				final Editable text = dnaET.getText();
				if (text.length() >= 1) {
					text.delete(text.length() - 1, text.length());
				}
			}
		}
	};




}
