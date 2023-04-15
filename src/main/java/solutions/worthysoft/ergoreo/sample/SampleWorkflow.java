package solutions.worthysoft.ergoreo.sample;

import solutions.worthysoft.ergoreo.Branchpoint;
import solutions.worthysoft.ergoreo.Mergepoint;
import solutions.worthysoft.ergoreo.Task;
import solutions.worthysoft.ergoreo.Workflow;

public class SampleWorkflow extends Workflow {
    
    public SampleWorkflow(String name) {
        Task task1 = new Task1();
        Task task2 = new Task1();
        Task task3 = new Task1();
        Branchpoint bp1 = new Branchpoint();
        Mergepoint mp1 = new Mergepoint();

        this.setEntryPoint(task1);
        task1.addSuccessor(bp1);
        bp1.addSuccessor(task2);
        bp1.addSuccessor(task3);
        task2.addSuccessor(mp1);
        task3.addSuccessor(mp1);
    }
}
