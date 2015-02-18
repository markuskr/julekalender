package no.knowit.julekalender.luke19;


import no.knowit.julekalender.Helpers;

public class Luke19 {

    private static String TEXT = "JegtroringenkanleveetheltlivutenkjærlighetMenkjærlighetenharmange" +
            "ansikterIhøstkomdetutenboksomheterErlikKjærlighetDenbeståravsamtaler" +
            "medselgereavgatemagasinetsomnåeretablertimangenorskebyerAlleharde" +
            "enhistorieåfortelleomkjærlighetsomnoeavgjørendeEntendetertilen" +
            "partneretfamiliemedlemenvennelleretkjæledyrMangeharopplevdåbli" +
            "sveketogselvåsvikteMenutrolignokblirikkekjærlighetsevnenødelagt" +
            "allikevelDenbyggesoppigjengangpågangKjærligheteneretstedåfeste" +
            "blikketDengirossretningognoeåstyreetterDengirossverdisommennesker" +
            "ognoeåleveforPåsammemåtesomkjærligheteneretfundamentimenneskelivet" +
            "erGrunnlovenetfundamentfornasjonenNorgeFor200årsidensamletengruppe" +
            "mennsegpåEidsvollforålagelovensomskullebligrunnlagettildetselvstendige" +
            "NorgeGrunnlovensomdengangblevedtattharutvikletsegipaktmedtidenog" +
            "sikreridagdetnorskefolkrettigheterviletttarforgittihverdagenRettighetersom" +
            "menneskerimangeandrelandbarekandrømmeomogsomdeslossformedlivet" +
            "sominnsatsJeghåperatvigjennomjubileumsfeiringeni2014vilbliminnetom" +
            "hvaGrunnlovenegentligbetyrforosssåvikanfortsetteåarbeideforverdiene" +
            "vårebådeherhjemmeoginternasjonaltJegharlysttilånevnenoeneksempler" +
            "påhvordanGrunnlovenvirkerinnpåenkeltmenneskerslivTenkdegatduskriver" +
            "etkritiskinnleggomlandetsstyrepåsosialemedier".toLowerCase();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // Takes around 7 milliseconds on my mac book pro
        System.out.println(solve() + " Took: " + (System.currentTimeMillis() - start));
    }



    public static String solve(){

        String maxPalindrom = "";
        for (int j = 0; j < TEXT.length(); j++) {
            for (int i = TEXT.length(); i > j; i--) {
                String sub = TEXT.substring(j, i);

                if (Helpers.isPalindrom(sub) && sub.length() > maxPalindrom.length()){
                    maxPalindrom = sub;
                }
            }
        }

        return maxPalindrom;
    }

}
