public class Client {
    private int id;
    private String nom;
    private String numeroIFU;
    private String RCCM;
    private String adresse;
    private String codeAPE;

    // Constructeur
    public Client(int id, String nom, String numeroIFU, String RCCM, String adresse, String codeAPE) {
        this.id = id;
        this.nom = nom;
        this.numeroIFU = numeroIFU;
        this.RCCM = RCCM;
        this.adresse = adresse;
        this.codeAPE = codeAPE;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroIFU() {
        return numeroIFU;
    }

    public void setNumeroIFU(String numeroIFU) {
        this.numeroIFU = numeroIFU;
    }

    public String getRCCM() {
        return RCCM;
    }

    public void setRCCM(String RCCM) {
        this.RCCM = RCCM;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodeAPE() {
        return codeAPE;
    }

    public void setCodeAPE(String codeAPE) {
        this.codeAPE = codeAPE;
    }
}
