package tec;

import java.lang.reflect.*;

//Cette méthode va récupérer toutes les méthodes des classes héritées 
//et exécuter celles qui commencent par "test".

abstract class LancerTests {

    static public void main (String[] args) throws Exception{
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
        return;
        }

        String[] testsClass = args;

        Class<?> c;

        for (int i = 0; i < testsClass.length; i++) {
            if (testsClass[i].startsWith("Test")) {
                c = null;
                try {
                    c = Class.forName("tec." + testsClass[i]);
                } catch (ClassNotFoundException e) {
                    System.out.println("Mauvais nom de test");
                }

                lancer(c);
            }
        }
    }

    static private void lancer(Class c) throws Exception {
        java.lang.reflect.Method[] mesMethodes = c.getMethods();
        int nbTest = 0;
        int res = 0;
        int j;

        for (j = 0; j < mesMethodes.length; j++) {
            java.lang.reflect.Method m = mesMethodes[j];
            if (m.getName().startsWith("test")) {
                System.out.print('.');
                try {
                    java.lang.reflect.Constructor constru = c.getDeclaredConstructor();
                    m.invoke(constru.newInstance());
                } catch (InvocationTargetException e) {
                    System.out.println(" " + m + ":KO: " + c.getName());
                    res = 1;
                }
                nbTest++;
            }
        }
        if (res == 0) {
            System.out.println("(" + nbTest + "):OK: " + c.getName());
        }
    }
}