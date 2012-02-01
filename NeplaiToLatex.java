//main class, to transliterate any Neplai text
//give text as argument, e.g.
//$>java NepaliToLatex "<Unicode neplai text to transliterate>"

public class NeplaiToLatex {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("please give the input in format\\" +
					"$>java NepaliToLatex \"<Unicode neplai text to transliterate>\"");
		}else {
			Transliterator utr = new Transliterator();
			System.out.println(utr.LatexRoman(args[0]));
		}
	}

}
