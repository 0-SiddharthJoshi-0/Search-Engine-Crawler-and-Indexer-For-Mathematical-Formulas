import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// This program generates math formula vector for each of the math formulae and creates the index of form:
// formula+formula vector+document number

public class IndexGenerator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File folder=new File("/Users/siddharthjoshi/IdeaProjects/Minor Project/src/WikiCorpus/Corpus2");
		File[] f=folder.listFiles();
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index.csv"),false));
		//PrintWriter pw3 = new PrintWriter(new FileOutputStream(new File("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/arthimetic.csv"),false));
		PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/TSDResult.txt"),true));
		long lStartTime = System.nanoTime();
		int count=0;
		for (File f1:f)
		{
			count++;
			System.out.println("Processing: "+count);
			if(!(f1.isDirectory()))
			{

				BufferedReader br=new BufferedReader(new FileReader(new File(f1.getAbsolutePath())));
				String line="";
				String origtext="";
				String content1=" "; // content1 refers to each math formula contained in document
				String content2=" ";// corresponds to each <mi>
				String content3=" ";//corresponds to each <mo>
				String content4=" ";// corresponds to content of <msup>  </msup> content
				String content5=" ";//corresponds to content of <msub>  </msub> content
				while((line=br.readLine())!=null)
				{
					origtext+=line;
				}
				String open1 = "(?<=\\<math>)";
				String inside1 = ".*?";
				String close1 = "(?=\\</math>)";;
				String regex1 = open1 + inside1 + close1;
				Matcher matcher1 = Pattern.compile(regex1, Pattern.DOTALL).matcher(origtext);

				while (matcher1.find()) { // corresponds to each formula

					content1 = matcher1.group().trim();
					System.out.println(content1);
					int[] formulavector = new int[202];
					String open2 = "(?<=\\<mi>)";
					String inside2 = ".*?";
					String close2 = "(?=\\</mi>)";;
					String regex2 = open2 + inside2 + close2;
					Matcher matcher2 = Pattern.compile(regex2, Pattern.DOTALL).matcher(content1);

					String open3 = "(?<=\\<mo>)";
					String inside3 = ".*?";
					String close3 = "(?=\\</mo>)";;
					String regex3 = open3 + inside3 + close3;
					Matcher matcher3 = Pattern.compile(regex3, Pattern.DOTALL).matcher(content1);

					String open4 = "(?<=\\<msup>)";
					String inside4 = ".*?";
					String close4 = "(?=\\</msup>)";
					String regex4 = open4 + inside4 + close4;
					Matcher matcher4 = Pattern.compile(regex4, Pattern.DOTALL).matcher(content1);

					String open5 = "(?<=\\<msub>)";
					String inside5 = ".*?";
					String close5 = "(?=\\</msub>)";
					String regex5 = open5 + inside5 + close5;
					Matcher matcher5 = Pattern.compile(regex5, Pattern.DOTALL).matcher(content1);

					while (matcher4.find())
					{
						content4 = matcher4.group().trim();
						if((content4.contains("<mi>a</mi>"))||(content4.contains("<mi>A</mi>")))
							formulavector[150]=1;
						if((content4.contains("<mi>b</mi>"))||(content4.contains("<mi>B</mi>") ))
							formulavector[151]=1;
						if((content4.contains("<mi>c</mi>"))||(content4.contains("<mi>C</mi>")) )
							formulavector[152]=1;
						if((content4.contains("<mi>d</mi>"))||(content4.contains("<mi>D</mi>") ))
							formulavector[153]=1;
						if((content4.contains("<mi>e</mi>"))||(content4.contains("<mi>E</mi>") ))
							formulavector[154]=1;
						if((content4.contains("<mi>f</mi>"))||(content4.contains("<mi>F</mi>") ))
							formulavector[155]=1;
						if((content4.contains("<mi>g</mi>"))||(content4.contains("<mi>G</mi>") ))
							formulavector[156]=1;
						if((content4.contains("<mi>h</mi>"))||(content4.contains("<mi>H</mi>") ))
							formulavector[157]=1;
						if((content4.contains("<mi>i</mi>"))||(content4.contains("<mi>I</mi>") ))
							formulavector[158]=1;
						if((content4.contains("<mi>j</mi>"))||(content4.contains("<mi>J</mi>") ))
							formulavector[159]=1;
						if((content4.contains("<mi>k</mi>"))||(content4.contains("<mi>K</mi>")))
							formulavector[160]=1;
						if((content4.contains("<mi>l</mi>"))||(content4.contains("<mi>L</mi>")))
							formulavector[161]=1;
						if((content4.contains("<mi>m</mi>"))||(content4.contains("<mi>M</mi>") ))
							formulavector[162]=1;
						if((content4.contains("<mi>n</mi>"))||(content4.contains("<mi>N</mi>") ))
							formulavector[163]=1;
						if((content4.contains("<mi>o</mi>"))||(content4.contains("<mi>O</mi>") ))
							formulavector[164]=1;
						if((content4.contains("<mi>p</mi>"))||(content4.contains("<mi>P</mi>")) )
							formulavector[165]=1;
						if((content4.contains("<mi>q</mi>"))||(content4.contains("<mi>Q</mi>") ))
							formulavector[166]=1;
						if((content4.contains("<mi>r</mi>"))||(content4.contains("<mi>R</mi>")) )
							formulavector[167]=1;
						if((content4.contains("<mi>s</mi>"))||(content4.contains("<mi>S</mi>") ))
							formulavector[168]=1;
						if((content4.contains("<mi>t</mi>"))||(content4.contains("<mi>T</mi>")) )
							formulavector[169]=1;
						if((content4.contains("<mi>u</mi>"))||(content4.contains("<mi>U</mi>")) )
							formulavector[170]=1;
						if((content4.contains("<mi>v</mi>"))||(content4.contains("<mi>V</mi>")) )
							formulavector[171]=1;
						if((content4.contains("<mi>w</mi>"))||(content4.contains("<mi>W</mi>")) )
							formulavector[172]=1;
						if((content4.contains("<mi>x</mi>"))||(content4.contains("<mi>X</mi>")) )
							formulavector[173]=1;
						if((content4.contains("<mi>y</mi>"))||(content4.contains("<mi>Y</mi>") ))
							formulavector[174]=1;
						if((content4.contains("<mi>z</mi>"))||(content4.contains("<mi>Z</mi>")) )
							formulavector[175]=1;

					}

					while (matcher5.find())
					{
						content5 = matcher5.group().trim();
						if((content5.contains("<mi>a</mi>")) || (content5.contains("<mi>A</mi>")))
							formulavector[176] = 1;
						if((content5.contains("<mi>b</mi>")) || (content5.contains("<mi>B</mi>")))
							formulavector[177] = 1;
						if((content5.contains("<mi>c</mi>")) || (content5.contains("<mi>C</mi>")))
							formulavector[178] = 1;
						if((content5.contains("<mi>d</mi>")) || (content5.contains("<mi>D</mi>")))
							formulavector[179] = 1;
						if((content5.contains("<mi>e</mi>")) || (content5.contains("<mi>E</mi>")))
							formulavector[180] = 1;
						if((content5.contains("<mi>f</mi>")) || (content5.contains("<mi>F</mi>")))
							formulavector[181] = 1;
						if((content5.contains("<mi>g</mi>")) || (content5.contains("<mi>G</mi>")))
							formulavector[182] = 1;
						if((content5.contains("<mi>h</mi>")) || (content5.contains("<mi>H</mi>")))
							formulavector[183] = 1;
						if((content5.contains("<mi>i</mi>")) || (content5.contains("<mi>I</mi>")))
							formulavector[184] = 1;
						if((content5.contains("<mi>j</mi>")) || (content5.contains("<mi>J</mi>")))
							formulavector[185] = 1;
						if((content5.contains("<mi>k</mi>")) || (content5.contains("<mi>K</mi>")))
							formulavector[186] = 1;
						if((content5.contains("<mi>l</mi>")) || (content5.contains("<mi>L</mi>")))
							formulavector[187] = 1;
						if((content5.contains("<mi>m</mi>")) || (content5.contains("<mi>M</mi>")))
							formulavector[188] = 1;
						if((content5.contains("<mi>n</mi>")) || (content5.contains("<mi>N</mi>")))
							formulavector[189] = 1;
						if((content5.contains("<mi>o</mi>")) || (content5.contains("<mi>O</mi>")))
							formulavector[190] = 1;
						if((content5.contains("<mi>p</mi>")) || (content5.contains("<mi>P</mi>")))
							formulavector[191] = 1;
						if((content5.contains("<mi>q</mi>")) || (content5.contains("<mi>Q</mi>")))
							formulavector[192] = 1;
						if((content5.contains("<mi>r</mi>")) || (content5.contains("<mi>R</mi>")))
							formulavector[193] = 1;
						if((content5.contains("<mi>s</mi>")) || (content5.contains("<mi>S</mi>")))
							formulavector[194] = 1;
						if((content5.contains("<mi>t</mi>")) || (content5.contains("<mi>T</mi>")))
							formulavector[195] = 1;
						if((content5.contains("<mi>u</mi>")) || (content5.contains("<mi>U</mi>")))
							formulavector[196] = 1;
						if((content5.contains("<mi>v</mi>")) || (content5.contains("<mi>V</mi>")))
							formulavector[197] = 1;
						if((content5.contains("<mi>w</mi>")) || (content5.contains("<mi>W</mi>")))
							formulavector[198] = 1;
						if((content5.contains("<mi>x</mi>")) || (content5.contains("<mi>X</mi>")))
							formulavector[199] = 1;
						if((content5.contains("<mi>y</mi>")) || (content5.contains("<mi>Y</mi>")))
							formulavector[200] = 1;
						if((content5.contains("<mi>z</mi>")) || (content5.contains("<mi>Z</mi>")))
							formulavector[201] = 1;


					}

					while(matcher2.find()) // content 2 corresponds to content of mi tag.
					{
						content2 = matcher2.group().trim();
						if(content2.contains("exp") )
							formulavector[4]=1;
						if(content2.contains("log")||content2.contains("ln"))
							formulavector[88]=1;
						if(content2.contains("cos")|| content2.contains("sin") || content2.contains("tan")||content2.contains("cot")||content2.contains("sinh")||content2.contains("cosh"))
							formulavector[90]=1;
						if(content2.contains("gcd") )
							formulavector[93]=1;
						if(content2.contains("xor") )
							formulavector[94]=1;
						char[] content2array=content2.toCharArray();

						if(content2array.length==1)
						{
							for(char ch:content2array)
							{

								if (ch == 'a' || ch == 'A') formulavector[0] = 1;
								if (ch == 'b' || ch == 'B') formulavector[1] = 1;
								if (ch == 'c' || ch == 'C') formulavector[2] = 1;
								if (ch == 'd' || ch == 'D') formulavector[3] = 1;
								if (ch == 'e' || ch == 'E') formulavector[4] = 1;
								if (ch == 'f' || ch == 'F') formulavector[5] = 1;
								if (ch == 'g' || ch == 'G') formulavector[6] = 1;
								if (ch == 'h' || ch == 'H' || ch == 'ℋ') formulavector[7] = 1;
								if (ch == 'i' || ch == 'I') formulavector[8] = 1;
								if (ch == 'j' || ch == 'J') formulavector[9] = 1;
								if (ch == 'k' || ch == 'K') formulavector[10] = 1;
								if (ch == 'l' || ch == 'L') formulavector[11] = 1;
								if (ch == 'm' || ch == 'M') formulavector[12] = 1;
								if (ch == 'n' || ch == 'N') formulavector[13] = 1;
								if (ch == '0' || ch == 'O') formulavector[14] = 1;
								if (ch == 'p' || ch == 'P') formulavector[15] = 1;
								if (ch == 'q' || ch == 'Q') formulavector[16] = 1;
								if (ch == 'r' || ch == 'R') formulavector[17] = 1;
								if (ch == 's' || ch == 'S') formulavector[18] = 1;
								if (ch == 't' || ch == 'T') formulavector[19] = 1;
								if (ch == 'u' || ch == 'U') formulavector[20] = 1;
								if (ch == 'v' || ch == 'V') formulavector[21] = 1;
								if (ch == 'w' || ch == 'W') formulavector[22] = 1;
								if (ch == 'x' || ch == 'X') formulavector[23] = 1;
								if (ch == 'y' || ch == 'Y') formulavector[24] = 1;
								if (ch == 'z' || ch == 'Z' || ch == 'ℤ') formulavector[25] = 1;

								if (ch == 'ϕ' || ch == '∅') formulavector[71] = 1;
								if (ch == 'ℏ') formulavector[72] = 1;
								if (ch == 'π') formulavector[73] = 1;
								if (ch == 'Δ') formulavector[74] = 1;
								if (ch == 'μ') formulavector[75] = 1;
								if (ch == 'Σ') formulavector[76] = 1;
								if (ch == 'ϵ') formulavector[77] = 1;
								if (ch == '…') formulavector[78] = 1;
								if (ch == 'δ') formulavector[79] = 1;
								if (ch == 'Ψ') formulavector[80] = 1;
								if (ch == 'Γ') formulavector[81] = 1;
								if (ch == '∞') formulavector[82] = 1;
								if (ch == 'ρ') formulavector[83] = 1;
								if (ch == 'β') formulavector[84] = 1;
								if (ch == 'λ') formulavector[85] = 1;
								if (ch == 'ξ') formulavector[86] = 1;
								if (ch == '□') formulavector[87] = 1;
								if (ch == '!') formulavector[89] = 1;
								if (ch == 'ℝ') formulavector[91] = 1;
								if (ch == 'θ') formulavector[92] = 1;
								if (ch == 'τ') formulavector[95] = 1;
								if (ch == 'η') formulavector[96] = 1;
								if (ch == 'σ') formulavector[97] = 1;
								if (ch == 'Ω') formulavector[98] = 1;
								if (ch == '#') formulavector[99] = 1;
								if (ch == '⌜') formulavector[100] = 1;
								if(ch=='ℤ')
									formulavector[57]=1;
								if(ch=='ℕ')
									formulavector[58]=1;
								if(ch=='ℚ')
									formulavector[59]=1;
								if(ch=='⌝')
									formulavector[60]=1;
								if(ch=='α')
									formulavector[61]=1;
								if(ch=='γ')
									formulavector[62]=1;
								if(ch=='ω')
									formulavector[63]=1;
								if(ch=='ϑ')
									formulavector[64]=1;
							}

						}

					}// end of matcher2 i.e. end of searching of <mi> tag contents

					while(matcher3.find()) // content 3 corresponds to content of mo tag.
					{
						content3 = matcher3.group().trim();
						if(content3.contains("lim"))
							formulavector[127]=1;
						if(content3.contains("det"))
							formulavector[139]=1;
						if(content3.contains("mod"))
							formulavector[141]=1;
						if(content3.contains("sup"))
							formulavector[142]=1;
						if(content3.contains("dim"))
							formulavector[144]=1;
						if(content3.contains(":="))
							formulavector[145]=1;
						if(content3.contains("max"))
							formulavector[147]=1;
						if(content3.contains("inf"))
							formulavector[148]=1;
						if(content3.contains("min"))
							formulavector[149]=1;
						if(content3.contains("Null"))
							formulavector[66]=1;
						if(content3.contains("dist"))
							formulavector[69]=1;

						char[] content3array=content3.toCharArray();

						if(content3array.length==1)
						{
							for(char ch:content3array)
							{
								if(ch=='=')
									formulavector[26]=1;
								if(ch==' ')
									formulavector[27]=1;
								if(ch=='-')
									formulavector[28]=1;
								if(ch==',')
									formulavector[29]=1;
								if(ch=='+')
									formulavector[30]=1;
								if(ch=='∇')
									formulavector[31]=1;
								if(ch=='∂')
									formulavector[32]=1;
								if(ch=='→')
									formulavector[33]=1;
								if(ch=='.')
									formulavector[34]=1;
								if(ch=='(')
									formulavector[35]=1;
								if(ch==')')
									formulavector[36]=1;
								if(ch=='≡')
									formulavector[37]=1;
								if(ch=='≫')
									formulavector[38]=1;
								if(ch=='∝')
									formulavector[39]=1;
								if(ch=='≈')
									formulavector[40]=1;
								if(ch=='/')
									formulavector[41]=1;
								if(ch=='⊆')
									formulavector[42]=1;
								if(ch=='⊕')
									formulavector[43]=1;
								if(ch=='∼')
									formulavector[44]=1;
								if(ch=='|')
									formulavector[45]=1;
								if(ch=='≠') // mo starts again at 101
									formulavector[101]=1;
								if(ch=='{')
									formulavector[102]=1;
								if(ch=='}')
									formulavector[103]=1;
								if(ch=='⊙')
									formulavector[104]=1;
								if(ch=='≼'||ch=='≤'||ch=='≲')
									formulavector[105]=1;
								if(ch=='∈')
									formulavector[106]=1;
								if(ch=='[')
									formulavector[107]=1;
								if(ch==']')
									formulavector[108]=1;
								if(ch=='*'||ch=='×')
									formulavector[109]=1;
								if(ch=='∉')
									formulavector[110]=1;
								if(ch=='^')
									formulavector[111]=1;
								if(ch=='∑')
									formulavector[112]=1;
								if(ch==';')
									formulavector[113]=1;
								if(ch=='¯')
									formulavector[114]=1;
								if(ch=='⇔')
									formulavector[115]=1;
								if(ch=='⟹')
									formulavector[116]=1;
								if(ch=='⌈')
									formulavector[117]=1;
								if(ch=='⌉')
									formulavector[118]=1;
								if(ch=='∀')
									formulavector[119]=1;
								if(ch=='±')
									formulavector[120]=1;
								if(ch=='∫')
									formulavector[121]=1;
								if(ch=='∘')
									formulavector[122]=1;
								if(ch=='′')
									formulavector[123]=1;
								if(ch=='∧')
									formulavector[124]=1;
								if(ch=='∃')
									formulavector[125]=1;
								if(ch=='¬')
									formulavector[126]=1;
								if(ch=='!')
									formulavector[89]=1;
								if(ch=='⟨'||ch=='<')
									formulavector[128]=1;
								if(ch=='⟩'||ch=='>')
									formulavector[129]=1;
								if(ch=='⊗')
									formulavector[130]=1;
								if(ch=='⊢')
									formulavector[131]=1;
								if(ch=='⊓')
									formulavector[132]=1;
								if(ch=='⊔')
									formulavector[133]=1;
								if(ch=='∥')
									formulavector[134]=1;
								if(ch=='∪')
									formulavector[135]=1;
								if(ch=='∩')
									formulavector[136]=1;
								if(ch=='↦')
									formulavector[137]=1;
								if(ch=='⊂')
									formulavector[138]=1;
								if(ch=='∏')
									formulavector[140]=1;
								if(ch=='≥'||ch=='≳')
									formulavector[143]=1;
								if(ch=='≅')
									formulavector[146]=1;
								if(ch=='†')
									formulavector[67]=1;
								if(ch==':')
									formulavector[68]=1;
								if(ch=='∓')
									formulavector[70]=1;

							}
						}
					}// end of matcher3 i.e. end of <mo> tag contents

					if(content1.contains("<mfrac>"))
						formulavector[46]=1;
					if(content1.contains("<mn>"))
						formulavector[47]=1;
					if(content1.contains("<msub>"))
						formulavector[48]=1;
					if(content1.contains("<msup>"))
						formulavector[49]=1;
					if(content1.contains("<msubsup>"))
						formulavector[50]=1;
					if(content1.contains("<mover>"))
						formulavector[51]=1;
					if(content1.contains("<munderover>"))
						formulavector[52]=1;
					if(content1.contains("<munder>"))
						formulavector[53]=1;
					if(content1.contains("<mtable>"))
						formulavector[54]=1;
					if(content1.contains("<mmultiscripts>"))
						formulavector[55]=1;
					if(content1.contains("<msqrt>"))
						formulavector[56]=1;
					//	pw.print(content1+"\t");
					// This will print the formulae and its vector representation

					String filename=f1.getName().replace(".xhtml", "");
					//	pw.println("\t"+f1.getName());
					pw.print(filename);
					pw.print(",");
					for(int i=0;i<formulavector.length;i++)
					{
						System.out.print(formulavector[i]);
						pw.print(formulavector[i]);
					}
					pw.println();
					//	pw.println("\t"+"<math>"+content1+"</math>");
					System.out.println();



				}// end of matcher1 i.e. end of one formula

			}
		}
		long lEndTime = System.nanoTime();
		long output = lEndTime - lStartTime;
		System.out.println("Elapsed time in milliseconds: " + output / 1000000);
		pw2.println("Elapsed time in milliseconds Indexing: "+output);
		pw2.close();
		pw.close();
	}

}
