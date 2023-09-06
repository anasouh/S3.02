package main;

public interface Interactable<T>
{
    public void interagir( T truc);

    public void dire(String txt);

    public void dire(String txt, Color c);
}
