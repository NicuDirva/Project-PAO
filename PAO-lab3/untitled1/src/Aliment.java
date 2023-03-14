import java.util.Arrays;

public class Aliment {
    private Long dataExp;
    private String[] ingrediente;
    private Double pret;
    private Double kcal;
    enum CATEGORIE{
        PAINE,
        MEZELURI,
        LACTATE
    }

    public Aliment(Long dataExp, String[] ingrediente, Double pret, Double kcal) {
        this.dataExp = dataExp;
        this.ingrediente = ingrediente;
        this.pret = pret;
        this.kcal = kcal;
    }

    public void setDataExp(Long dataExp) {
        this.dataExp = dataExp;
    }

    public void setIngrediente(String[] ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Long getDataExp() {
        return dataExp;
    }

    public String[] getIngrediente() {
        return ingrediente;
    }

    public Double getPret() {
        return pret;
    }

    public Double getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "dataExp=" + dataExp +
                ", ingrediente=" + Arrays.toString(ingrediente) +
                ", pret=" + pret +
                ", kcal=" + kcal +
                '}';
    }

    public int comparare(Aliment a2)
    {
        if(this.kcal > a2.kcal)
            return 1;
        return 0;
    }



}
