package bankapp;

import java.util.Hashtable;
import java.util.NoSuchElementException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    Integer unum, bnum;
    int n = 3;
    
    Banks[] barr = new Banks[n];
    
    

    @Override
    public void start(Stage window) throws Exception {

        String inname1 = "Chase"; //Example Names of Banks and thier amounts for each
        double inbalance1 = 321;
        String inname2 = "American Express";
        double inbalance2 = 123;
        String inname3 = "Citi";
        double inbalance3 = 111;
        

        
        Banks[] blankbarr = new Banks[n];
        QueueList queue = new QueueList();

        Banks[] barr1 = new Banks[n]; //Bank Array for USER 0
        barr1[0] = new Banks(inname1, inbalance1); //Example Bank names and amounts
        barr1[1] = new Banks();
        barr1[1].setName(inname2);
        barr1[1].setBal(inbalance2);
        barr1[2] = new Banks(inname3, inbalance3);

        Banks[] barr2 = new Banks[n];//Bank Array for USER 1
        barr2[0] = new Banks("American", 100);//Example Names of Banks and thier amounts for each
        barr2[1] = new Banks("Discover", 510);
        barr2[2] = new Banks("HSBC", 202);

        Banks[] barr3 = new Banks[n];//Bank Array for USER 2
        barr3[0] = new Banks("Ally", 2000000);//Example Names of Banks and thier amounts for each
        barr3[1] = new Banks("Valley", 25);
        barr3[2] = new Banks("Chase", 2050);

        Hashtable<Integer, Banks[]> users = new Hashtable<Integer, Banks[]>(); //Initialize Hash of User Accounts
        /*for(int x=0;x<n-1;x++){ //Used to Bind the next Key to the seperate Banks[]
      System.out.println("Enter Name: ");
      s=in.next();
      users.put(x,barr);
    }*/

        users.put(0, barr1);// USER 0
        users.put(1, barr2);// USER 1
        users.put(2, barr3);// USER 2

        boolean stop = false;
        boolean stop2 = false;
        boolean stop3 = false;
        //user number
        String fname, command;//find name, input command
        double amountw, amountd;//amount withdrew, amount deposited

        command = "";

//-------------------------------------------------------------------------------        
        window.setTitle("Log-In Menu");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Banking App");
        sceneTitle.setId("bank");
        grid.add(sceneTitle, 0, 0, 2, 1);
        //grid2.add(sceneTitle, 0, 0, 2, 1);

        Label accountId = new Label("Account ID: ");
        grid.add(accountId, 0, 1);

        Label Balance = new Label("Total Balance");
        grid2.add(Balance, 0, 1);

        TextField accountIdTextField = new TextField();
        grid.add(accountIdTextField, 1, 1);

        Button signInButton = new Button("Sign in");
        HBox hbBtn = new HBox(14);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(signInButton);
        grid.add(hbBtn, 1, 4);

        Button btn2 = new Button("Check Total Balance");
        HBox hbBtn2 = new HBox(14);
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn2.getChildren().add(btn2);
        grid2.add(hbBtn2, 1, 4);

        final Text actionTarget2 = new Text();
        grid2.add(actionTarget2, 1, 1);
        
        Scene scene1 = new Scene(grid, 500, 500);
        Scene scene2 = new Scene(grid2, 500, 500);

        signInButton.setOnAction((ActionEvent e) -> {
            unum = Integer.parseInt(accountIdTextField.getText());
            
                window.setScene(scene2);
            
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actionTarget2.setText(String.valueOf(100));

            }
        });

        window.setScene(scene1);
        scene1.getStylesheets().add(ComboProj.class.getResource("BankApp.css").toExternalForm());
        scene2.getStylesheets().add(ComboProj.class.getResource("BankApp.css").toExternalForm());

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

class Banks {

    String bnames;
    double bbalance;

    Banks() {
        bnames = "null";
        bbalance = 0.0;
    }

    Banks(String newname, double newbalance) { //Passed name and balance for Bank
        bnames = newname;
        bbalance = newbalance;
    }

    public void setName(String name) { //Sets new Name for Bank
        bnames = name;
    }

    public void setBal(double balance) { //Sets new Balance for Bank
        bbalance = balance;
    }

    String getName() { //Returns Bank Name
        return bnames;
    }

    double getBal() { //Returns Bank Balance
        return bbalance;
    }

    double addBal(double amount) { //Increases Bank Balance
        bbalance += amount;
        return bbalance;
    }

    double subBal(double amount) { //Decreases Bank Balance
        bbalance -= amount;
        return bbalance;
    }
}

class QueueList {

    private class NodeQue {

        String transectionType;
        double amount;
        int unum;
        String barrname;
        NodeQue next2;

        public NodeQue(int unum, String barrname, String transectionType, double amount) {
            String val = transectionType.toUpperCase();
            this.unum = unum;
            this.barrname = barrname;
            this.transectionType = val;
            this.amount = amount;
        }
    }
    private NodeQue head2, tail2;
    private int cntNode;

    public void enque(Banks[] barr, int unum, String barrname, String transectionType, double amount) {
        NodeQue node = new NodeQue(unum, barrname, transectionType, amount);
        cntNode++;
        if (head2 == null) {
            head2 = tail2 = node;
            return;
        }
        tail2.next2 = node;
        tail2 = node;
    }

    public double deque() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        double result = head2.amount;
        NodeQue current = head2.next2;
        head2.next2 = null;
        head2 = current;
        cntNode--;
        return result;
    }

    /*public double totalBalance() {
   NodeQue current = head2;
   //StackList deposit = new StackList();
   //StackList withdraw = new StackList();
   double depositTotal = 0.0; double withdrawTotal = 0.0;
   while(current != null) {
   if(current.transectionType.equals("DEPOSIT"))
   depositTotal += (current.amount);
   else
   withdrawTotal += (current.amount);
   }
   return depositTotal-withdrawTotal;
   }*/
    public int size() {
        return cntNode;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void display() {
        NodeQue temp = head2;
        while (temp != null) {
            System.out.println("User " + temp.unum + " " + temp.barrname + " " + temp.transectionType + " " + temp.amount);
            temp = temp.next2;
        }
    }
}
