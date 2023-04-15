package solutions.worthysoft.ergoreo;

public abstract class Task implements Step {

    public abstract void build(Inputs inputs);
    
    public abstract Report execute();

    @Override
    public Steps getPredecessors() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Steps getSuccessors() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addPredecessor(Step predecessor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removePredecessor(Step predecessor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addSuccessor(Step successor) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeSuccessor(Step successor) {
        // TODO Auto-generated method stub
        
    }

}
