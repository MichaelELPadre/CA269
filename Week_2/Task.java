import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}
class Task {
    final String title;
    String description;
    LocalDate scheduled;
    LocalDate deadline;
    State state;

     public Task(String title, State state, String description, LocalDate scheduled, LocalDate deadline){
        this.title = title;
        this.setState(state);
        this.setScheduled(scheduled);
        this.setDeadline(deadline);
        this.setDescription(description);
    }

    public Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription() {
        return description;
    }
    public LocalDate getScheduled(){
        return scheduled;
    }
    public LocalDate getDeadline(){
        return deadline;
    }




    public void setScheduled(LocalDate scheduled){
        this.scheduled = scheduled;
    }
    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

    public State getState(){
        return state;
    }
    public void setState(State state){
        this.state = state;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    public String toString() {
        String message = this.title + " (" + this.state + ")";
        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if (deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
    }

public static void main(String[] args) {
    Task t1 = new Task("Test", State.TODO);
        LocalDate now = LocalDate.now();
        t1.setScheduled(now);
        System.out.println(t1);















    Task s1 = new Chore("Test", State.TODO, LocalDate.now(), LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(s1);
        s1.setState(State.DONE);
        System.out.println(s1);



        /* 
    RepeatedTask r1 = new RepeatedTask("RepeatedTask Test", State.WAIT);
        System.out.println(r1);
        r1.setState(State.DONE);
        System.out.println(r1);
        System.out.println(r1.getDescription().toLowerCase());
    
    Task t2 = new SharedTask("Test", "Alice");
        System.out.println(t2);

    Dependency d1 = new Dependency("Dependency Test", State.HALT, t1);
        System.out.println(d1);
        d1.setState(State.DONE);
        System.out.println(d1);
        t1.setState(State.DONE);
        System.out.println(d1);
*/
    }
}










class Chore extends Task {
    LocalDate repeat;

    public LocalDate getRepeat(){
        return repeat;
    }
    public void setRepeat(LocalDate repeat){
        this.repeat = repeat;
    }


    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }


    public void setState(State state) {
        super.setState(state);
        if (state == State.DONE) {
            LocalDate repeat_new = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(repeat_new);
            setState(state.TODO);
        }
    }
}












class RepeatedTask extends Task {
    RepeatedTask(String title, State state){
        super(title, state);
    }

    public void setState(State state){
        super.setState(state);

        if (state == state.DONE) {
            setState(state.TODO);;
        }
    }
}

class SharedTask extends Task {
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    SharedTask(String title, String name) {
        super(title, State.WAIT);
        setName(name);
    }

    @Override
    public String toString() {
        return super.toString() + " shared with: " + name;
    }
}


class Dependency extends Task {
    Task task_dependency;

    public Task getTaskDependency(Task task_dependency) {
        return task_dependency;
    }
    public void setTaskDependency(Task task_dependency) {
        this.task_dependency = task_dependency;
    }

    Dependency(String title, State state, Task task_dependency) {
        super(title, state);
        setTaskDependency(task_dependency);
    }

    public void setState(State state) {
        if (state == State.DONE && task_dependency.state == State.DONE) {
            this.state = state;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " dependent on: " + task_dependency.title + " ("+ task_dependency.state +")";
    }
}