package com.example.sqliteexample;

class Pokemon {
    private String name;
    private String type;
    private int pic;

    public Pokemon(String name, String type, int pic) {
        this.name = name;
        this.type = type;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
