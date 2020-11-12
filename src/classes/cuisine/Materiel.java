package classes.cuisine;

public class Materiel {

    private int tempsExecution;
    private Object[] tableauMaterielContenu;

    public Materiel(int capaciteMax, int tempsExecution) {
        this.tempsExecution = tempsExecution;
        tableauMaterielContenu = new Object[capaciteMax];
    }

    public void ajouterIngredient(Object ingredient) throws IllegalAccessException {
        int plein = 0;
        for (int i = 0; i < tableauMaterielContenu.length; i++) {
            if (tableauMaterielContenu[i] == null) {
                plein = 0;
                tableauMaterielContenu[i] = ingredient;
                i = tableauMaterielContenu.length;
                System.out.println(ingredient.toString() + " ajout�");

            } else {
                plein = 1;
            }
        }

        if (plein == 1) {
            throw new IllegalAccessException("plein");
        }
    }

}