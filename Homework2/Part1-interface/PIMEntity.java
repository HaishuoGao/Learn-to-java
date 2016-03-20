interface PIMEntity {
    // default constructor sets priority to "normal"
    void PIMEntity();

    // priority can be established via this constructor.
    void PIMEntity(String priority);

    // accessor method for getting the priority string
    String getPriority();

    // method that changes the priority string
    void setPriority(String p);

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    void fromString(String s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    String toString();
}