public enum Tarif {
    Kompakt(1f),
    Optimal(1.2f),
    Premium(1.4f);

    private float faktor;

    private Tarif(float faktor) {
        this.faktor = faktor;
    }

    public float getFaktor(){
        return faktor;
    }
}
