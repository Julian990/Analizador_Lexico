/* Generated By:JavaCC: Do not edit this line. comp.java */
package semantico;
import java.io.*;
import java.io.File;
import java.util.Scanner;
public class comp implements compConstants {

        public static void main( String[] args )throws ParseException, Exception
        {
            try
                {
                File initialFile = new File("C:/temp/code.txt");
                    InputStream targetStream = new FileInputStream(initialFile);

                comp analizador = new comp(targetStream);
                        analizador.Programa();
                        System.out.println("\u005ctAnalizador ha terminado.");
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        System.out.println("\u005ctAnalizador ha terminado.");
                }
        }

  static final public void Programa() throws ParseException {
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SEMICOLON);
    Bloque();
    jj_consume_token(0);
  }

  static final public void Bloque() throws ParseException {
    if (jj_2_1(2)) {
      VariablesGlobales();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAIN:
        Principal();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void VariablesGlobales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PRIVATE:
      jj_consume_token(PRIVATE);
      break;
    case PUBLIC:
      jj_consume_token(PUBLIC);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case DEC:
      jj_consume_token(DEC);
      break;
    case STR:
      jj_consume_token(STR);
      break;
    case CHR:
      jj_consume_token(CHR);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(IDENTIFIER);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
    }
    jj_consume_token(SEMICOLON);
    Bloque();
  }

  static final public void Principal() throws ParseException {
        TokenAsignaciones.SetTables();
    jj_consume_token(PROGRAMA);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(SEMICOLON);    
    jj_consume_token(PUBLIC);
    jj_consume_token(CLASS);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(LBRACE);
    jj_consume_token(MAIN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

  static final public void VariablesLocales() throws ParseException {
        int td;
        Token var;
    TiposDatos();
                td = token.kind;
    var = jj_consume_token(IDENTIFIER);
                TokenAsignaciones.InsertarSimbolo(var, td);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      VariablesAsignacion(var);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      jj_consume_token(COMMA);
      var = jj_consume_token(IDENTIFIER);
                        TokenAsignaciones.InsertarSimbolo(var, td);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASIGNACION:
        VariablesAsignacion(var);
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
    }
    jj_consume_token(SEMICOLON);
    VS();
  }

  static final public void VariablesAsignacion(Token v1) throws ParseException {
        Token v2;
        Token v3;
        String res;
        boolean imp = false;
    jj_consume_token(ASIGNACION);
    TiposAsignaciones();
                v2 = token;
                res = TokenAsignaciones.checkAsing(v1, v2);

                if(res != " ")
                {
                        System.out.println(res);
                        imp = true;
                }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
      case MULTIPLY:
      case DIVIDE:
      case NUMBER:
      case IDENTIFIER:
      case DECIMAL:
      case CADENA:
      case CARAC:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      OpAritmetico();
      TiposAsignaciones();
                v3 = token;
                res = TokenAsignaciones.checkAsing(v1, v3);

                if(res != " " && !imp)
                {
                        System.out.println(res);
                }
    }
  }

  static final public void VS() throws ParseException {
    if (jj_2_2(3)) {
      VariablesLocales();
    } else {
      Sentencias();
    }
  }

  static final public void Sentencias() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case FOR:
      case SWITCH:
      case DO:
      case WHILE:
      case WRITE:
      case READ:
      case INT:
      case DEC:
      case CHR:
      case STR:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case DEC:
      case CHR:
      case STR:
        VariablesLocales();
        break;
      case IF:
        SentenciaIf();
        break;
      case FOR:
        SentenciaFor();
        break;
      case DO:
      case WHILE:
        SentenciaDo();
        break;
      default:
        jj_la1[9] = jj_gen;
        if (jj_2_3(2)) {
          SentenciaAsignacion();
          jj_consume_token(SEMICOLON);
                                                       TokenAsignaciones.segunda = 0;
        } else {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case WRITE:
            SentenciaWrite();
            break;
          case READ:
            SentenciaRead();
            jj_consume_token(SEMICOLON);
            break;
          case SWITCH:
            SentenciaSwitch();
            break;
          default:
            jj_la1[10] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
  }

//Sentencia IF
  static final public void SentenciaIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    A();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
      case ELSEIF:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_5;
      }
      Sino();
    }
  }

  static final public void Sino() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      jj_consume_token(LBRACE);
      Sentencias();
      jj_consume_token(RBRACE);
      break;
    case ELSEIF:
      jj_consume_token(ELSEIF);
      jj_consume_token(LPAREN);
      A();
      jj_consume_token(RPAREN);
      jj_consume_token(LBRACE);
      Sentencias();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void A() throws ParseException {
    Comparaciones();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
      case NUMBER:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OR:
      case AND:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          jj_consume_token(AND);
          break;
        case OR:
          jj_consume_token(OR);
          break;
        default:
          jj_la1[14] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[15] = jj_gen;
        ;
      }
      Comparaciones();
    }
  }

//Fin sentencia if
  static final public void Comparaciones() throws ParseException {
    Valor();
    Operadores();
    Valor();
  }

  static final public void Valor() throws ParseException {
    if (jj_2_4(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        break;
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case IDENTIFIER:
        Expresion();
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Expresion() throws ParseException {
    if (jj_2_5(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case IDENTIFIER:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          jj_consume_token(IDENTIFIER);
          break;
        case NUMBER:
          jj_consume_token(NUMBER);
          break;
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        OpAritmetico();
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          jj_consume_token(IDENTIFIER);
          break;
        case NUMBER:
          jj_consume_token(NUMBER);
          break;
        default:
          jj_la1[20] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Operadores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case EQ:
      jj_consume_token(EQ);
      break;
    case LE:
      jj_consume_token(LE);
      break;
    case GE:
      jj_consume_token(GE);
      break;
    case NE:
      jj_consume_token(NE);
      break;
    case GR:
      jj_consume_token(GR);
      break;
    case MN:
      jj_consume_token(MN);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public int OpAritmetico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
                   {if (true) return 1;}
      break;
    case MINUS:
      jj_consume_token(MINUS);
                    {if (true) return 1;}
      break;
    case MULTIPLY:
      jj_consume_token(MULTIPLY);
                       {if (true) return 1;}
      break;
    case DIVIDE:
      jj_consume_token(DIVIDE);
                     {if (true) return 1;}
      break;
    default:
      jj_la1[23] = jj_gen;
            {if (true) return 0;}
         {if (true) return 0;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public void TiposDatos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case DEC:
      jj_consume_token(DEC);
      break;
    case STR:
      jj_consume_token(STR);
      break;
    case CHR:
      jj_consume_token(CHR);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//Sentencia FOR
  static final public void SentenciaFor() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(LPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case DEC:
    case CHR:
    case STR:
      DeclaracionUnaVariable();
      break;
    case IDENTIFIER:
      SentenciaAsignacion();
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(SEMICOLON);
    Comparaciones();
    jj_consume_token(SEMICOLON);
    SentenciaAsignacion();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

  static final public void DeclaracionUnaVariable() throws ParseException {
        int td;
        Token var;
    TiposDatos();
                td = token.kind;
    var = jj_consume_token(IDENTIFIER);
                TokenAsignaciones.InsertarSimbolo(var, td);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      VariablesAsignacion(var);
      break;
    default:
      jj_la1[26] = jj_gen;
      ;
    }
  }

//Sentencia DO
  static final public void SentenciaDo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DO:
      jj_consume_token(DO);
      jj_consume_token(LBRACE);
      Sentencias();
      jj_consume_token(RBRACE);
      jj_consume_token(WHILE);
      jj_consume_token(LPAREN);
      Comparaciones();
      jj_consume_token(RPAREN);
      break;
    case WHILE:
      SentenciaWhile();
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void SentenciaWhile() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    Comparaciones();
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    Sentencias();
    jj_consume_token(RBRACE);
  }

//Sentencia ASIGNACION
  static final public void SentenciaAsignacion() throws ParseException {
        Token v1;
        Token v2;
        Token v3;
        int aux;
        String res;
        boolean imp = false;
    v1 = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      TiposAsignaciones();
    v2 = token;
        res = TokenAsignaciones.checkAsing(v1, v2);

        if(res != " ")
        {
                System.out.println(res);
                imp = true;
        }
      label_7:
      while (true) {
        if (jj_2_6(2)) {
          ;
        } else {
          break label_7;
        }
        OpAritmetico();
        TiposAsignaciones();
    v3 = token;
        res = TokenAsignaciones.checkAsing(v1, v3);

        if(res != " " && !imp)
        {
                System.out.println(res);
        }
      }
      break;
    case INCR:
    case DECR:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        jj_consume_token(INCR);
        break;
      case DECR:
        jj_consume_token(DECR);
        break;
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
        res = TokenAsignaciones.checkVariable(v1);

        if(res != " ")
                System.out.println(res);
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TiposAsignaciones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case DECIMAL:
      jj_consume_token(DECIMAL);
      break;
    case CADENA:
      jj_consume_token(CADENA);
      break;
    case CARAC:
      jj_consume_token(CARAC);
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//Sentencia WRITE
  static final public void SentenciaWrite() throws ParseException {
    jj_consume_token(WRITE);
    jj_consume_token(LPAREN);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case IDENTIFIER:
      case CADENA:
        ;
        break;
      default:
        jj_la1[31] = jj_gen;
        break label_8;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case IDENTIFIER:
        Expresion();
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
            ;
            break;
          default:
            jj_la1[32] = jj_gen;
            break label_9;
          }
          jj_consume_token(PLUS);
          jj_consume_token(CADENA);
        }
        break;
      case CADENA:
        jj_consume_token(CADENA);
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case PLUS:
            ;
            break;
          default:
            jj_la1[33] = jj_gen;
            break label_10;
          }
          jj_consume_token(PLUS);
          Expresion();
        }
        break;
      default:
        jj_la1[34] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(RPAREN);
    jj_consume_token(SEMICOLON);
  }

//Sentencia READ
  static final public void SentenciaRead() throws ParseException {
    jj_consume_token(READ);
    jj_consume_token(LPAREN);
    jj_consume_token(RPAREN);
  }

  static final public void SentenciaSwitch() throws ParseException {
    jj_consume_token(SWITCH);
    jj_consume_token(LPAREN);
    jj_consume_token(IDENTIFIER);
    jj_consume_token(RPAREN);
    jj_consume_token(LBRACE);
    label_11:
    while (true) {
      jj_consume_token(CASE);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        jj_consume_token(IDENTIFIER);
        break;
      case CADENA:
        jj_consume_token(CADENA);
        break;
      case CARAC:
        jj_consume_token(CARAC);
        break;
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case DECIMAL:
        jj_consume_token(DECIMAL);
        break;
      default:
        jj_la1[35] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(DOUBLEPOINT);
      label_12:
      while (true) {
        SentenciaAsignacion();
        jj_consume_token(SEMICOLON);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[36] = jj_gen;
          break label_12;
        }
      }
      jj_consume_token(BREAK);
      jj_consume_token(SEMICOLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASE:
        ;
        break;
      default:
        jj_la1[37] = jj_gen;
        break label_11;
      }
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DEFAUL:
      jj_consume_token(DEFAUL);
      jj_consume_token(DOUBLEPOINT);
      SentenciaAsignacion();
      jj_consume_token(SEMICOLON);
      jj_consume_token(BREAK);
      jj_consume_token(SEMICOLON);
      break;
    default:
      jj_la1[38] = jj_gen;
      ;
    }
    jj_consume_token(RBRACE);
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  static private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  static private boolean jj_3R_14() {
    if (jj_3R_18()) return true;
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_19()) jj_scanpos = xsp;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_20()) { jj_scanpos = xsp; break; }
    }
    if (jj_scan_token(SEMICOLON)) return true;
    return false;
  }

  static private boolean jj_3R_27() {
    return false;
  }

  static private boolean jj_3R_26() {
    if (jj_scan_token(DIVIDE)) return true;
    return false;
  }

  static private boolean jj_3R_25() {
    if (jj_scan_token(MULTIPLY)) return true;
    return false;
  }

  static private boolean jj_3R_24() {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  static private boolean jj_3R_16() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_23()) {
    jj_scanpos = xsp;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) {
    jj_scanpos = xsp;
    if (jj_3R_26()) {
    jj_scanpos = xsp;
    if (jj_3R_27()) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_23() {
    if (jj_scan_token(PLUS)) return true;
    return false;
  }

  static private boolean jj_3R_28() {
    if (jj_scan_token(ASIGNACION)) return true;
    return false;
  }

  static private boolean jj_3R_13() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(9)) {
    jj_scanpos = xsp;
    if (jj_scan_token(8)) return true;
    }
    xsp = jj_scanpos;
    if (jj_scan_token(44)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3_3() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_22() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(6)) {
    jj_scanpos = xsp;
    if (jj_scan_token(7)) return true;
    }
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_13()) return true;
    return false;
  }

  static private boolean jj_3R_20() {
    if (jj_scan_token(COMMA)) return true;
    return false;
  }

  static private boolean jj_3_6() {
    if (jj_3R_16()) return true;
    if (jj_3R_17()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_3R_14()) return true;
    return false;
  }

  static private boolean jj_3_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_scan_token(49)) return true;
    }
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_3R_28()) return true;
    return false;
  }

  static private boolean jj_3_4() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) return true;
    }
    return false;
  }

  static private boolean jj_3R_21() {
    if (jj_scan_token(ASIGNACION)) return true;
    return false;
  }

  static private boolean jj_3R_15() {
    if (jj_scan_token(IDENTIFIER)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_21()) {
    jj_scanpos = xsp;
    if (jj_3R_22()) return true;
    }
    return false;
  }

  static private boolean jj_3R_18() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(44)) {
    jj_scanpos = xsp;
    if (jj_scan_token(45)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(46)) return true;
    }
    }
    }
    return false;
  }

  static private boolean jj_3R_17() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(49)) {
    jj_scanpos = xsp;
    if (jj_scan_token(48)) {
    jj_scanpos = xsp;
    if (jj_scan_token(50)) {
    jj_scanpos = xsp;
    if (jj_scan_token(51)) {
    jj_scanpos = xsp;
    if (jj_scan_token(52)) return true;
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public compTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[39];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1000,0x300,0x0,0x0,0x2,0x0,0x2,0x3c,0x3c64000,0xc24000,0x3040000,0x18000,0x18000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3c,0x0,0x0,0x2,0xc00000,0xc0,0xc2,0x0,0x0,0x4,0x4,0x0,0x0,0x0,0x80000,0x200000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0xf000,0x2,0x0,0x2,0x0,0x1f0000,0x2f000,0xf000,0x0,0x0,0x0,0x30c00,0xc00,0xc00,0x30000,0x30000,0x30000,0x30000,0x30000,0x30000,0x3f0,0x0,0xf000,0x2f000,0x0,0x0,0x0,0x0,0x1f0000,0xb0000,0x0,0x0,0xb0000,0x1f0000,0x20000,0x0,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[6];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public comp(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public comp(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public comp(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new compTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public comp(compTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(compTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 39; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[59];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 39; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 59; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 6; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
