package solutions.worthysoft.ergoreo;

public abstract class Workflow {
    private Step entryPoint = null;

    public Step getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(Step entryPoint) {
        this.entryPoint = entryPoint;
    }

    private Memories memories = new Memories();

    public Memories getMemories() {
        return memories;
    }

    private History history = new History();

    public History getHistory() {
        return history;
    }

    private static Status status = Status.NOT_STARTED;

    public static Status getStatus() {
        return status;
    }

    public final void start() {
        status = Status.RUNNING;
        Inputs inputs = new Inputs();
        executeStep(entryPoint, inputs);
    }

    private void executeStep(Step step, Inputs inputs) {
        if (status == Status.RUNNING) {
            step.build(inputs);
            Report report = step.execute();
            history.addAll(report.getHistory());
            memories.putAll(report.getMemories());
            Steps successors = step.getSuccessors();
            if (successors.size() == 1) {
                executeStep(successors.get(0), inputs);
            } else if (successors.size() > 1) {
                successors.forEach(child -> new Runnable() {
                    public void run() {
                        executeStep(child, inputs);
                    }
                });
            } else {
                //No successors -- do nothing
            }
        } else if (status == Status.PAUSED) {
            while (status != Status.RUNNING) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //Ignore
                }
            }
            executeStep(step, inputs);
        } else {
            //MUST BE TERMINATED, SO STOP
        }
    }

    public final void pause() {
        status = Status.PAUSED;
    }

    public final void resume() {
        status = Status.RUNNING;
    }

    public final void terminate() {
        status = Status.TERMINATED;
    }

}