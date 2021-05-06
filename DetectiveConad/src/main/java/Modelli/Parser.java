package Modelli;

import java.util.*;

public class Parser {

    private final Set<String> stopwords;

    public Parser(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    private int checkForCommand(String token, List<Comando> comandi) {
        for (int i = 0; i < comandi.size(); i++) {
            if (comandi.get(i).getNome().equals(token) || comandi.get(i).getSinonimi().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    private int checkForObject(String token, List<Oggetto> oggetti) {
        for (int i = 0; i < oggetti.size(); i++) {
            if (oggetti.get(i).getNome().equals(token) || oggetti.get(i).getSinonimi().contains(token)) {
                return i;
            }
        }
        return -1;
    }

    public ParserOutput parse(String comando, List<Comando> comandi, List<Oggetto> oggetti, List<Oggetto> inventario) {
        List<String> tokens = Utils.parseString(comando, stopwords);
        if (!tokens.isEmpty()) {
            int ic = checkForCommand(tokens.get(0), comandi);
            if (ic > -1) {
                if (tokens.size() > 1) {
                    int io = checkForObject(tokens.get(1), oggetti);
                    int ioinv = -1;
                    if (io < 0 && tokens.size() > 2) {
                        io = checkForObject(tokens.get(2), oggetti);
                    }
                    if (io < 0) {
                        ioinv = checkForObject(tokens.get(1), inventario);
                        if (ioinv < 0 && tokens.size() > 2) {
                            ioinv = checkForObject(tokens.get(2), inventario);
                        }
                    }
                    if (io > -1 && ioinv > -1) {
                        return new ParserOutput(comandi.get(ic), oggetti.get(io), inventario.get(ioinv));
                    } else if (io > -1) {
                        return new ParserOutput(comandi.get(ic), oggetti.get(io), null);
                    } else if (ioinv > -1) {
                        return new ParserOutput(comandi.get(ic), null, inventario.get(ioinv));
                    } else {
                        return new ParserOutput(comandi.get(ic), null, null);
                    }
                } else {
                    return new ParserOutput(comandi.get(ic), null);
                }
            } else {
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }

}
