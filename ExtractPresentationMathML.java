import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// Program removes all contents between <annotation-xml and </annotation>, it converts <math xref.... to <math> and so on
// It finally outputs processed math formulae.
// it takes files as input which contain only formula in raw format
public class ExtractPresentationMathML {

    public static void main(String[] args) throws Exception {

        File folder=new File("src/WikiCorpus/Corpus1");
        File[] f=folder.listFiles();
        int count=0;
        // Create a PrintWriter for the final output
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("src/WikiCorpus/TSDResult.txt"),true));
        long lStartTime = System.nanoTime();


        // Iterate through each file in the directory
        for (File f1:f)
        {
            if(!(f1.isDirectory()))
            {
                count++;
                System.out.println("Processing: "+count);
                // Create a PrintWriter for the final output
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src/WikiCorpus/Corpus2/"+f1.getName()),true));


                BufferedReader br=new BufferedReader(new FileReader(new File(f1.getAbsolutePath())));
                String line="";
                String origtext="";
                String content1=" ";
                String content2=" ";
                String content3=" ";
                String content4=" ";
                String content5=" ";
                String content6=" ";
                String content7=" ";
                String content8=" ";
                String content9=" ";
                String content10=" ";
                String content11=" ";
                String content12=" ";
                String content13=" ";
                String content14=" ";
                String content15=" ";
                String content16=" ";
                String content17=" ";
                //String finaltext= " ";

                // Read each line from the input file
                while((line=br.readLine())!=null)
                {
                    origtext+=line;// Accumulate lines of text
                }

                // Remove content between <annotation-xml> and </annotation>
                String open1 = "<annotation-xml";
                String inside1 = ".*?";
                String close1 = "</annotation>";
                String regex1 = open1 + inside1 + close1;
                Matcher matcher1 = Pattern.compile(regex1, Pattern.DOTALL).matcher(origtext);
                while (matcher1.find()) {
                    content1 = matcher1.group().trim();
                    origtext = origtext.replace(content1, " ");
                }

                String open2 = "<semantics";
                String inside2 = ".*?";
                String close2 = ">";
                String regex2 = open2 + inside2 + close2;
                Matcher matcher2 = Pattern.compile(regex2, Pattern.DOTALL).matcher(origtext);
                while (matcher2.find())
                {
                    content2 = matcher2.group().trim();
                    origtext=origtext.replace(content2, "<semantics>");
                }

                String open3 = "<mrow";
                String inside3 = ".*?";
                String close3 = ">";
                String regex3 = open3 + inside3 + close3;
                Matcher matcher3 = Pattern.compile(regex3, Pattern.DOTALL).matcher(origtext);
                while (matcher3.find())
                {
                    content3 = matcher3.group().trim();
                    origtext=origtext.replace(content3, "<mrow>");
                }

                String open4 = "<mo";
                String inside4 = ".*?";
                String close4 = ">";
                String regex4 = open4 + inside4 + close4;
                Matcher matcher4 = Pattern.compile(regex4, Pattern.DOTALL).matcher(origtext);
                while (matcher4.find())
                {
                    content4 = matcher4.group().trim();
                    origtext=origtext.replace(content4, "<mo>");
                }

                String open5 = "<mi";
                String inside5 = ".*?";
                String close5 = ">";
                String regex5 = open5 + inside5 + close5;
                Matcher matcher5 = Pattern.compile(regex5, Pattern.DOTALL).matcher(origtext);
                while (matcher5.find())
                {
                    content5 = matcher5.group().trim();
                    origtext=origtext.replace(content5, "<mi>");
                }

                String open6 = "<math";
                String inside6 = ".*?";
                String close6 = ">";
                String regex6 = open6 + inside6 + close6;
                Matcher matcher6 = Pattern.compile(regex6, Pattern.DOTALL).matcher(origtext);
                while (matcher6.find())
                {
                    content6 = matcher6.group().trim();
                    origtext=origtext.replace(content6, "<math>");
                }

                String open7 = "<mn";
                String inside7 = ".*?";
                String close7 = ">";
                String regex7 = open7 + inside7 + close7;
                Matcher matcher7 = Pattern.compile(regex7, Pattern.DOTALL).matcher(origtext);
                while (matcher7.find())
                {
                    content7 = matcher7.group().trim();
                    origtext=origtext.replace(content7, "<mn>");
                }

                String open8 = "<mfrac";
                String inside8 = ".*?";
                String close8 = ">";
                String regex8 = open8 + inside8 + close8;
                Matcher matcher8 = Pattern.compile(regex8, Pattern.DOTALL).matcher(origtext);
                while (matcher8.find())
                {
                    content8 = matcher8.group().trim();
                    origtext=origtext.replace(content8, "<mfrac>");
                }

                String open9 = "<msub";
                String inside9 = ".*?";
                String close9 = ">";
                String regex9 = open9 + inside9 + close9;
                Matcher matcher9 = Pattern.compile(regex9, Pattern.DOTALL).matcher(origtext);
                while (matcher9.find())
                {
                    content9 = matcher9.group().trim();
                    origtext=origtext.replace(content9, "<msub>");
                }

                String open10 = "<mpadded";
                String inside10 = ".*?";
                String close10 = ">";
                String regex10 = open10 + inside10 + close10;
                Matcher matcher10 = Pattern.compile(regex10, Pattern.DOTALL).matcher(origtext);
                while (matcher10.find())
                {
                    content10 = matcher10.group().trim();
                    origtext=origtext.replace(content10, "<mpadded>");
                }

                String open11 = "<msup";
                String inside11 = ".*?";
                String close11 = ">";
                String regex11 = open11 + inside11 + close11;
                Matcher matcher11 = Pattern.compile(regex11, Pattern.DOTALL).matcher(origtext);
                while (matcher11.find())
                {
                    content11 = matcher11.group().trim();
                    origtext=origtext.replace(content11, "<msup>");
                }

                String open12 = "<msqrt";
                String inside12 = ".*?";
                String close12 = ">";
                String regex12 = open12 + inside12 + close12;
                Matcher matcher12 = Pattern.compile(regex12, Pattern.DOTALL).matcher(origtext);
                while (matcher12.find())
                {
                    content12 = matcher12.group().trim();
                    origtext=origtext.replace(content12, "<msqrt>");
                }

                String open13 = "<msubsup";
                String inside13 = ".*?";
                String close13 = ">";
                String regex13 = open13 + inside13 + close13;
                Matcher matcher13 = Pattern.compile(regex13, Pattern.DOTALL).matcher(origtext);
                while (matcher13.find())
                {
                    content13 = matcher13.group().trim();
                    origtext=origtext.replace(content13, "<msubsup>");
                }

                String open14 = "<mover";
                String inside14 = ".*?";
                String close14 = ">";
                String regex14 = open14 + inside14 + close14;
                Matcher matcher14 = Pattern.compile(regex14, Pattern.DOTALL).matcher(origtext);
                while (matcher14.find())
                {
                    content14 = matcher14.group().trim();
                    origtext=origtext.replace(content14, "<mover>");
                }

                String open15 = "<mi";
                String inside15 = ".*?";
                String close15 = ">";
                String regex15 = open15 + inside15 + close15;
                Matcher matcher15 = Pattern.compile(regex15, Pattern.DOTALL).matcher(origtext);
                while (matcher15.find())
                {
                    content15 = matcher15.group().trim();
                    origtext=origtext.replace(content15, "<mi>");
                }

                String open16 = "<mstyle";
                String inside16 = ".*?";
                String close16 = ">";
                String regex16 = open16 + inside16 + close16;
                Matcher matcher16 = Pattern.compile(regex16, Pattern.DOTALL).matcher(origtext);
                while (matcher16.find())
                {
                    content16 = matcher16.group().trim();
                    origtext=origtext.replace(content16, "<mstyle>");
                }

                String open17 = "<munderover";
                String inside17 = ".*?";
                String close17 = ">";
                String regex17 = open17 + inside17 + close17;
                Matcher matcher17 = Pattern.compile(regex17, Pattern.DOTALL).matcher(origtext);
                while (matcher17.find())
                {
                    content17 = matcher17.group().trim();
                    origtext=origtext.replace(content17, "<munderover>");
                }
                pw.println(origtext);
                br.close();
                pw.flush();
                pw.close();
            }

        }
        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;

        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
        pw2.println("Elapsed time in milliseconds Pre-processing-II: "+output/1000000);
        pw2.close();

    }

}
