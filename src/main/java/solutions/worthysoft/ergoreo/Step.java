package solutions.worthysoft.ergoreo;

public interface Step {
    public Steps getPredecessors();
    public Steps getSuccessors();
    public void addPredecessor(Step predecessor);
    public void removePredecessor(Step predecessor);
    public void addSuccessor(Step successor);
    public void removeSuccessor(Step successor);
    public void build(Inputs inputs);
    public Report execute();
}
