package de.jendrik.proteinbiosynthese;

import java.util.HashMap;
import de.jendrik.proteinbiosynthese.aminosäure.Alanin;
import de.jendrik.proteinbiosynthese.aminosäure.Aminosäure;
import de.jendrik.proteinbiosynthese.aminosäure.Arginin;
import de.jendrik.proteinbiosynthese.aminosäure.Asparagin;
import de.jendrik.proteinbiosynthese.aminosäure.Asparaginsäure;
import de.jendrik.proteinbiosynthese.aminosäure.Cystein;
import de.jendrik.proteinbiosynthese.aminosäure.Glutamin;
import de.jendrik.proteinbiosynthese.aminosäure.Glutaminsäure;
import de.jendrik.proteinbiosynthese.aminosäure.Glycin;
import de.jendrik.proteinbiosynthese.aminosäure.Histidin;
import de.jendrik.proteinbiosynthese.aminosäure.Isoleucin;
import de.jendrik.proteinbiosynthese.aminosäure.Leucin;
import de.jendrik.proteinbiosynthese.aminosäure.Lysin;
import de.jendrik.proteinbiosynthese.aminosäure.Methionin;
import de.jendrik.proteinbiosynthese.aminosäure.Phenylalalin;
import de.jendrik.proteinbiosynthese.aminosäure.Prolin;
import de.jendrik.proteinbiosynthese.aminosäure.Serin;
import de.jendrik.proteinbiosynthese.aminosäure.Stop;
import de.jendrik.proteinbiosynthese.aminosäure.Threonin;
import de.jendrik.proteinbiosynthese.aminosäure.Tryptophan;
import de.jendrik.proteinbiosynthese.aminosäure.Tyrosin;
import de.jendrik.proteinbiosynthese.aminosäure.Valin;

class CodeSonneMap extends HashMap<String, Aminosäure> {

	public static final Aminosäure ala = new Alanin();
	public static final Aminosäure arg = new Arginin();
	public static final Aminosäure asn = new Asparagin();
	public static final Aminosäure asp = new Asparaginsäure();
	public static final Aminosäure cys = new Cystein();
	public static final Aminosäure gln = new Glutamin();
	public static final Aminosäure glu = new Glutaminsäure();
	public static final Aminosäure gly = new Glycin();
	public static final Aminosäure his = new Histidin();
	public static final Aminosäure ile = new Isoleucin();
	public static final Aminosäure leu = new Leucin();
	public static final Aminosäure lys = new Lysin();
	public static final Aminosäure met = new Methionin();
	public static final Aminosäure phe = new Phenylalalin();
	public static final Aminosäure pro = new Prolin();
	public static final Aminosäure ser = new Serin();
	public static final Aminosäure thr = new Threonin();
	public static final Aminosäure trp = new Tryptophan();
	public static final Aminosäure tyr = new Tyrosin();
	public static final Aminosäure val = new Valin();

	public static final Aminosäure stop = new Stop();

	{
		put("AAA", lys);
		put("AAG", lys);
		put("AAU", asn);
		put("AAC", asn);
		put("AGA", arg);
		put("AGG", arg);
		put("AGU", ser);
		put("AGC", ser);
		put("AUA", ile);
		put("AUG", met);
		put("AUU", ile);
		put("AUC", ile);
		put("ACA", thr);
		put("ACG", thr);
		put("ACU", thr);
		put("ACC", thr);
		put("GAA", glu);
		put("GAG", glu);
		put("GAU", asp);
		put("GAC", asp);
		put("GGA", gly);
		put("GGG", gly);
		put("GGU", gly);
		put("GGC", gly);
		put("GUA", val);
		put("GUG", val);
		put("GUU", val);
		put("GUC", val);
		put("GCA", ala);
		put("GCG", ala);
		put("GCU", ala);
		put("GCC", ala);
		put("UAA", stop);
		put("UAG", stop);
		put("UAU", tyr);
		put("UAC", tyr);
		put("UGA", stop);
		put("UGG", trp);
		put("UGU", cys);
		put("UGC", cys);
		put("UUA", leu);
		put("UUG", leu);
		put("UUU", phe);
		put("UUC", phe);
		put("UCA", ser);
		put("UCG", ser);
		put("UCU", ser);
		put("UCC", ser);
		put("CAA", gln);
		put("CAG", gln);
		put("CAU", his);
		put("CAC", his);
		put("CGA", arg);
		put("CGG", arg);
		put("CGU", arg);
		put("CGC", arg);
		put("CUC", leu);
		put("CUA", leu);
		put("CUG", leu);
		put("CUU", leu);
		put("CCA", pro);
		put("CCG", pro);
		put("CCU", pro);
		put("CCC", pro);
	}

	@Override
	public Aminosäure put(final String key, final Aminosäure value) {
		return super.put(key.toUpperCase(), value);
	}
}
