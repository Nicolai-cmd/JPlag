package de.jplag.python3;

import java.io.File;

import de.jplag.ProgramI;
import de.jplag.TokenList;

public class Language implements de.jplag.Language {

    private Parser parser;

    public Language(ProgramI program) {
        this.parser = new Parser();
        this.parser.setProgram(program);
    }

    @Override
    public String[] suffixes() {
        String[] res = {".py"};
        return res;
    }

    @Override
    public int errorsCount() {
        return this.parser.errorsCount();
    }

    @Override
    public String name() {
        return "Python3 AbstractParser";
    }

    @Override
    public String getShortName() {
        return "python3";
    }

    @Override
    public int min_token_match() {
        return 12;
    }

    @Override
    public TokenList parse(File dir, String[] files) {
        return this.parser.parse(dir, files);
    }

    @Override
    public boolean hasErrors() {
        return this.parser.hasErrors();
    }

    @Override
    public boolean supportsColumns() {
        return true;
    }

    @Override
    public boolean isPreformatted() {
        return true;
    }

    @Override
    public boolean usesIndex() {
        return false;
    }

    @Override
    public int noOfTokens() {
        return Python3TokenConstants.NUM_DIFF_TOKENS;
    }

    @Override
    public String type2string(int type) {
        return Python3Token.type2string(type);
    }
}