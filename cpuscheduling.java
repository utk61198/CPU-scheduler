


import com.sun.javafx.geom.AreaOp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.JFrame;


public class cpuscheduling extends JFrame implements ActionListener {

    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    static int e = 0;
    static int f = 0;


    String[] burstarray;
    int[] b_array;

    String[] arrivalarray;
    int[] a_array;
    String[] priorityarray;
    

    int[][] ba_array;
    int[][] ab_array;
    int[] aa;
    int[] ba;
    int[] pid;
    int[] pa;
    JLabel info1=new JLabel();
    JLabel info2=new JLabel();
    JLabel info3=new JLabel();
    
    JLabel info4=new JLabel();
    JLabel info5=new JLabel();
    JLabel info6=new JLabel();
    
    


    double difference;
    double differenceratio;
    double idleLength[];


    JLabel numOfProc = new JLabel(" number of the processes <=6");
    JLabel burstTime = new JLabel("Busrt time       ");
    JLabel arrivalTime = new JLabel("Arrival time      ");

    JLabel priority = new JLabel("Priority"+"\n"+"(input 0 if priority not given)");
    JLabel timeQuantum = new JLabel("Time Quantum");
    Choice nop = new Choice();
    JTextField bt = new JTextField();
    JTextField at = new JTextField();
    JTextField pri = new JTextField();
    JTextField tq = new JTextField();
    JCheckBox fcfs = new JCheckBox("FCFS");
    JCheckBox rr = new JCheckBox("RR");
    JCheckBox p_sjf = new JCheckBox("P-SJF");
    JCheckBox np_sjf = new JCheckBox("NP-SJF");
    JCheckBox p_pri = new JCheckBox("P-PRI");
    JCheckBox np_pri = new JCheckBox("NP-PRI");
    JButton compute = new JButton("compute");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel(new FlowLayout());
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    JPanel panel9 = new JPanel();
    JFrame output = new JFrame();


    public cpuscheduling() {
        output.setLayout(new GridLayout(12,1));

        this.setLayout(new GridLayout(9, 1));
        panel1.setLayout(new FlowLayout());
        panel1.add(numOfProc);
        nop.setPreferredSize(new Dimension(30, 30));
        nop.add("1");
        nop.add("2");
        nop.add("3");
        nop.add("4");
        nop.add("5");
        nop.add("6");

        panel1.add(nop);

        panel2.add(burstTime);
        bt.setPreferredSize(new Dimension(300, 30));
        panel2.add(bt);
        panel3.add(arrivalTime);
        at.setPreferredSize(new Dimension(300, 30));
        panel3.add(at);
        panel4.add(priority);
        pri.setPreferredSize(new Dimension(300, 30));
        panel4.add(pri);
        panel5.add(timeQuantum);
        tq.setPreferredSize(new Dimension(300, 30));
        panel5.add(tq);
        panel6.add(fcfs);
        panel6.add(rr);
        panel7.add(p_sjf);
        panel7.add(np_sjf);
        panel8.add(p_pri);
        panel8.add(np_pri);
        panel9.add(compute);


        output.setSize(1920,1080);
        
     

        output.setVisible(false);


        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(panel7);
        this.add(panel8);
        this.add(panel9);
        compute.addActionListener(this);


    }


    public static void main(String[] args) {

        cpuscheduling obj = new cpu();
        obj.setVisible(true);
        obj.setSize(800, 800);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        int np = Integer.parseInt(nop.getSelectedItem());
        pid = new int[np];
        aa = new int[np];
        ba = new int[np];
        pa = new int[np];
        
        


        burstarray = bt.getText().split(",");
        arrivalarray = at.getText().split(",");
        b_array = new int[burstarray.length];
        a_array = new int[arrivalarray.length];
        idleLength = new double[burstarray.length];
        ba_array = new int[burstarray.length][2];
        ab_array = new int[burstarray.length][2];
        
           priorityarray = pri.getText().split(",");
        for (int i = 0; i < priorityarray.length; i++) {
            pa[i] = Integer.parseInt(priorityarray[i]);

        }
       

        for (int i = 0; i < burstarray.length; i++) {
            a_array[i] = Integer.parseInt(arrivalarray[i]);
            aa[i] = Integer.parseInt(arrivalarray[i]);

            b_array[i] = Integer.parseInt(burstarray[i]);
            ba[i] = Integer.parseInt(burstarray[i]);
            pid[i] = i;


        }

        for (int i = 0; i < ba_array.length; i++) {


            ba_array[i][0] = b_array[i];
            ba_array[i][1] = a_array[i];
            ab_array[i][0] = a_array[i];
            ab_array[i][1] = b_array[i];



        }


        if (fcfs.isSelected() == true) {

           
            a=1;
            
               FirstCome op = new FirstCome();
        output.add(op);
        output.add(info1);
        

            repaint();


        }

        if (np_sjf.isSelected() == true) {

            b = 1;
            shortestJobfirst ob=new shortestJobfirst();
            output.add(ob);
            output.add(info2);
            
            repaint();


        }

        if (rr.isSelected() == true) {
            c = 1;
            
            RoundRobin ob=new RoundRobin();
            output.add(ob);
            output.add(info3);
            
            
            repaint();

        }
        if (np_pri.isSelected() == true) {
            
          

            
            d = 1;
            NPriority ob=new NPriority();
            output.add(ob);
            output.add(info4);
            
            repaint();


        }

        if(p_sjf.isSelected()==true)
        {    e=1;
        
            PShortest ob=new PShortest();
            output.add(ob);
            
            repaint();
            

        }



        if (ae.getActionCommand().equals("compute")) {
            output.setVisible(true);


        }
    }


    class FirstCome extends JPanel {


        Random random = new Random();


        @Override
        protected void paintComponent(Graphics g) {
           


            super.paintComponent(g);
            
              for (int i = 0; i < priorityarray.length; i++) {
            pa[i] = Integer.parseInt(priorityarray[i]);

        }
              
               for (int i = 0; i < burstarray.length; i++) {
            a_array[i] = Integer.parseInt(arrivalarray[i]);
            aa[i] = Integer.parseInt(arrivalarray[i]);

            b_array[i] = Integer.parseInt(burstarray[i]);
            ba[i] = Integer.parseInt(burstarray[i]);
            pid[i] = i;


        }



             
              

                boolean[] check=new boolean[pid.length];

                ArrayList<Integer> chart=new ArrayList<Integer>();
                ArrayList<Integer> track=new ArrayList<Integer>();
                int limit=0;





                double sum=0;
                int temp=0;

                for (int i = 0; i < aa.length - 1; i++) {






                    for (int j = 0; j < aa.length - 1 - i; j++) {
                        if (aa[j] > aa[j + 1]) {
                            int temp1 = aa[j];
                            aa[j] = aa[j + 1];
                            aa[j + 1] = temp1;

                            int temp2 = ba[j];
                            ba[j] = ba[j + 1];
                            ba[j + 1] = temp2;


                            int temp3 = pid[j];
                            pid[j] = pid[j + 1];
                            pid[j + 1] = temp3;


                        }

                    }

                }
                  while(chart.size()!=pid.length)
                  {

                      for(int i=0;i<pid.length;i++)
                      {

                          if(aa[i]<=limit && check[pid[i]]==false)
                          {
                              chart.add(ba[i]);
                              track.add(pid[i]);
                              temp=ba[i];
                              check[pid[i]]=true;
                              



                          }

                      }


                      limit=limit+temp;



                  }




for(int i=0;i<chart.size();i++)
{
    sum=sum+chart.get(i);


}
      int et=0;
      g.drawString(""+et, 0, 40);

                double val1 = 0;


                for (int i = 0; i < chart.size(); i++) {
                    double ratio = (chart.get(i)) / sum;
                    
                   



                  double length = ratio * this.getWidth();
  g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fill3DRect((int) val1, 0, (int) length, 30, true);


                         g.setColor(Color.BLACK);
                         
                         int x=(int)(length/2);

                         g.drawString("P"+track.get(i), (int)(val1+x),40);
                         
                         


                    val1 = val1 + length;
                    



                }
                
                
               
                for(int i=0;i<chart.size();i++)
                {
                    et=et+chart.get(i);
                    double ratio=et/sum;
                    double length=ratio*this.getWidth();
                    
                    
                    g.drawString(et+" ",(int)length-20, 40);
                    
                    
                    
                }
                
                 
                     
                
                
                int[] ct=new int[pid.length];
                 int[] wt=new int[pid.length];
                 int[] tat=new int[pid.length];
                 for(int i=0;i<ct.length;i++)
                 {  int index=0;
                     for(int j=0;j<track.size();j++)
                     {
                         if(i==track.get(j))
                         {
                             index=j;
                             
                         }
                         
                     }
                     
                     int s=0;
                     for(int k=0;k<=index;k++)
                     {
                         s=s+chart.get(k);
                         
                         
                     }
                     
                     
                 ct[i]=s;
                 
                     
                     
                 }
                 
                 for(int i=0;i<ct.length;i++)
                 {
                     System.out.print(ct[i]+" ");
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     tat[i]=ct[i]-aa[index];
                     
                     
                     
                     
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     System.out.println(tat[i]+" ");
                 }
                 
                 
                 for(int i=0;i<wt.length;i++)
                 {
                      int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     wt[i]=tat[i]-ba[index];
                 }
                 
                 
                System.out.println("");
                for(int i=0;i<wt.length;i++)
                {
                    System.out.println(wt[i]+" ");
                    
                    
                    
                }
                
                 String display=" TAT of processes: ";
                 for(int i=0;i<tat.length;i++)
                 {
                     display=display+"P"+i+"-"+tat[i]+" ";
                     
                 }
                 
                 double avgtat=0;
                 for(int i=0;i<tat.length;i++)
                 {
                     avgtat=avgtat+tat[i];
                     
                 }
                 avgtat=avgtat/pid.length;
                 display=display+"  average TAT is: "+avgtat;
                 System.out.println(display);
                 
                 
                   String display1=" WT of processes: ";
                 for(int i=0;i<wt.length;i++)
                 {
                     display1=display1+"P"+i+"-"+wt[i]+" ";
                     
                 }
                 
                 double avgwt=0;
                 for(int i=0;i<wt.length;i++)
                 {
                     avgwt=avgwt+wt[i];
                     
                 }
                 avgwt=avgwt/pid.length;
                 display1=display1+"  average WT is: "+avgwt;
                 System.out.println(display1);
                 
                 
                  info1.setText(display+"                                      FCFS                                                             "+display1);
                 
                 
                 
                 
                
                 
                 
                 
                    
                
                
        }
        
      
        
        
        
        
        
        }
        
        
        


            











class shortestJobfirst extends JPanel
{

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                if (b == 1)
            {


                      for (int i = 0; i < priorityarray.length; i++) {
            pa[i] = Integer.parseInt(priorityarray[i]);

        }
              
               for (int i = 0; i < burstarray.length; i++) {
            a_array[i] = Integer.parseInt(arrivalarray[i]);
            aa[i] = Integer.parseInt(arrivalarray[i]);

            b_array[i] = Integer.parseInt(burstarray[i]);
            ba[i] = Integer.parseInt(burstarray[i]);
            pid[i] = i;


        }

                boolean[] check=new boolean[pid.length];
                ArrayList<Integer> chart = new ArrayList<Integer>();
                ArrayList<Integer> track = new ArrayList<Integer>();
                LinkedList<Integer> queue = new LinkedList<Integer>();
                int limit = 0;




                for (int i = 0; i < ba.length - 1; i++) {

                    for (int j = 0; j < ba.length - 1 - i; j++)
                    {
                        if (ba[j] > ba[j + 1]) {
                            int temp1 = ba[j];
                            ba[j] = ba[j + 1];
                            ba[j + 1] = temp1;

                            int temp2 = aa[j];
                            aa[j] = aa[j + 1];
                            aa[j + 1] = temp2;


                            int temp3 = pid[j];
                            pid[j] = pid[j + 1];
                            pid[j + 1] = temp3;


                        }


                    }

                }
                for (int i = 0; i < ba.length; i++) {
                    System.out.print(ba[i]+" ");


                }
                System.out.println(" ");

                for(int i=0;i<ba.length;i++)
                {
                    System.out.println(aa[i]);


                }
                System.out.println("this should be printed");

                for(int i=0;i<ba.length;i++)
                {
                    System.out.println(pid[i]);


                }


                int sum1=0;
                for(int i=0;i<ba.length;i++)
                {
                    sum1=sum1+ba[i];


                }
                while(chart.size()!=pid.length)



                {
                    int temp=0;


                    for(int i=0;i<aa.length;i++)
                    {
                        if(aa[i]<=limit  && check[pid[i]]==false)

                        {
                            check[pid[i]]=true;

                            chart.add(ba[i]);
                            temp=ba[i];

                            track.add(pid[i]);



                        }
                    }

                    System.out.println(track);

                    limit=limit+temp;
                }

                    double val1 = 0;
                    double sum = 0;

                    for (int i = 0; i < chart.size(); i++) {
                        sum = sum + chart.get(i);

                    }
                    for (int i = 0; i < chart.size(); i++)
                    {
                        double ratio = chart.get(i) / sum;


                        double length = ratio * this.getWidth();
Random random=new Random();


                        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        g.fill3DRect((int) val1, 0, (int) length, 30, true);
                        
                        
                         g.setColor(Color.BLACK);
                         
                         int x=(int)(length/2);

                         g.drawString("P"+track.get(i), (int)(val1+x),40);


                        val1 = val1 + length;



                    }
                    int et=0;
                    
                     for(int i=0;i<chart.size();i++)
                {
                    et=et+chart.get(i);
                    double ratio=et/sum;
                    double length=ratio*this.getWidth();
                    
                    
                    g.drawString(et+" ",(int)length-20, 40);
                    
                    
                    
                }
                      int[] ct=new int[pid.length];
                 int[] wt=new int[pid.length];
                 int[] tat=new int[pid.length];
                 for(int i=0;i<ct.length;i++)
                 {  int index=0;
                     for(int j=0;j<track.size();j++)
                     {
                         if(i==track.get(j))
                         {
                             index=j;
                             
                         }
                         
                     }
                     
                     int s=0;
                     for(int k=0;k<=index;k++)
                     {
                         s=s+chart.get(k);
                         
                         
                     }
                     
                     
                 ct[i]=s;
                 
                     
                     
                 }
                 
                 for(int i=0;i<ct.length;i++)
                 {
                     System.out.print(ct[i]+" ");
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     tat[i]=ct[i]-aa[index];
                     
                     
                     
                     
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     System.out.println(tat[i]+" ");
                 }
                 
                 
                 for(int i=0;i<wt.length;i++)
                 {
                      int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     wt[i]=tat[i]-ba[index];
                 }
                 
                 
                System.out.println("");
                for(int i=0;i<wt.length;i++)
                {
                    System.out.println(wt[i]+" ");
                    
                    
                    
                }
                
                 String display=" TAT of processes: ";
                 for(int i=0;i<tat.length;i++)
                 {
                     display=display+"P"+i+"-"+tat[i]+" ";
                     
                 }
                 
                 double avgtat=0;
                 for(int i=0;i<tat.length;i++)
                 {
                     avgtat=avgtat+tat[i];
                     
                 }
                 avgtat=avgtat/pid.length;
                 display=display+"  average TAT is: "+avgtat;
                 System.out.println(display);
                 
                 
                   String display1=" WT of processes: ";
                 for(int i=0;i<wt.length;i++)
                 {
                     display1=display1+"P"+i+"-"+wt[i]+" ";
                     
                 }
                 
                 double avgwt=0;
                 for(int i=0;i<wt.length;i++)
                 {
                     avgwt=avgwt+wt[i];
                     
                 }
                 avgwt=avgwt/pid.length;
                 display1=display1+"  average WT is: "+avgwt;
                 System.out.println(display1);
                 
                 
                 info2.setText(display+"                                      SJF                                                            "+display1);
               
                 
                     
                     
                     
                     
                     
                     

                }

            }































            

}




class RoundRobin extends JPanel
{

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                 if (c == 1) {

                boolean[] inReady = new boolean[pid.length];
                int t = Integer.parseInt(tq.getText());


                for (int i = 0; i < aa.length - 1; i++) {

                    for (int j = 0; j < aa.length - 1 - i; j++) {
                        if (aa[j] > aa[j + 1]) {
                            int temp1 = aa[j];
                            aa[j] = aa[j + 1];
                            aa[j + 1] = temp1;

                            int temp2 = ba[j];
                            ba[j] = ba[j + 1];
                            ba[j + 1] = temp2;


                            int temp3 = pid[j];
                            pid[j] = pid[j + 1];
                            pid[j + 1] = temp3;


                        }

                    }

                }
                int limit = 0;

                ArrayList<Integer> chart = new ArrayList<Integer>();
                ArrayList<Integer> track = new ArrayList<Integer>();


                LinkedList<Integer> ready = new LinkedList<Integer>();
                int temp = 0;
                if (aa[temp] <= limit) {
                    if (ba[temp] > t) {
                        ba[temp] = ba[temp] - t;
                        chart.add(t);
                        track.add(temp);

                        limit = limit + t;


                    } else {
                        chart.add(ba[temp]);
                        track.add(temp);
                        limit = limit + ba[temp];
                        ba[temp] = 0;




                    }
                }


                for (int i = 1; i < pid.length; i++) {
                    if (aa[i] <= limit && inReady[pid[i]] == false) {
                        ready.addLast(pid[i]);

                        inReady[pid[i]] = true;
                    }


                }

                while (!ready.isEmpty()) {


                    if (ba[temp] != 0) {
                        ready.addLast(pid[temp]);

                    }
                    int temp2 = ready.removeFirst();
                    for (int i = 0; i < pid.length; i++) {
                        if (pid[i] == temp2) {
                            temp = i;


                        }
                    }
                    if (aa[temp] <= limit) {
                        if (ba[temp] > t) {
                            ba[temp] = ba[temp] - t;
                            chart.add(t);
                            track.add(temp);
                            System.out.println(chart);

                            limit = limit + t;


                        } else {
                            chart.add(ba[temp]);
                            System.out.println(chart);
                            track.add(temp);
                            limit = limit + ba[temp];
                            ba[temp] = 0;


                        }
                    }

                    for (int i = 1; i < pid.length; i++) {
                        if (aa[i] <= limit && inReady[pid[i]] == false) {
                            ready.addLast(pid[i]);
                            inReady[pid[i]] = true;

                        }


                    }


                }

                chart.add(ba[temp]);
                track.add(temp);
                


                 int et=0;
      g.drawString(""+et, 0, 40);
                double val1 = 0;
                double sum = 0;

                for (int i = 0; i < chart.size(); i++) {
                    sum = sum + chart.get(i);

                }
               

                for (int i = 0; i < chart.size(); i++) {
                    double ratio = chart.get(i) / sum;


                    double length = ratio * this.getWidth();
                    
                    Random random=new Random();
                    


                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fill3DRect((int) val1, 0, (int) length, 30, true);
                    
                        g.setColor(Color.BLACK);
                         
                         int x=(int)(length/2);

                         g.drawString("P"+track.get(i), (int)(val1+x),40);


                    val1 = val1 + length;




                }
                 for(int i=0;i<chart.size();i++)
                {
                    et=et+chart.get(i);
                    double ratio=et/sum;
                    double length=ratio*this.getWidth();
                    
                    
                    g.drawString(et+" ",(int)length-20, 40);
                    
                    
                    
                }
                
                 
                     
                
                
                int[] ct=new int[pid.length];
                 int[] wt=new int[pid.length];
                 int[] tat=new int[pid.length];
                 for(int i=0;i<ct.length;i++)
                 {  int index=0;
                     for(int j=0;j<track.size();j++)
                     {
                         if(i==track.get(j))
                         {
                             index=j;
                             
                         }
                         
                     }
                     
                     int s=0;
                     for(int k=0;k<=index;k++)
                     {
                         s=s+chart.get(k);
                         
                         
                     }
                     
                     
                 ct[i]=s;
                 
                     
                     
                 }
                 
                 for(int i=0;i<ct.length;i++)
                 {
                     System.out.print(ct[i]+" ");
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     tat[i]=ct[i]-a_array[index];
                     
                     
                     
                     
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     System.out.println(tat[i]+" ");
                 }
                 
                 
                 for(int i=0;i<wt.length;i++)
                 {
                      int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     wt[i]=tat[i]-b_array[index];
                 }
                 
                 
                System.out.println("");
                for(int i=0;i<wt.length;i++)
                {
                    System.out.println(wt[i]+" ");
                    
                    
                    
                }
                
                 String display=" TAT of processes: ";
                 for(int i=0;i<tat.length;i++)
                 {
                     display=display+"P"+i+"-"+tat[i]+" ";
                     
                 }
                 
                 double avgtat=0;
                 for(int i=0;i<tat.length;i++)
                 {
                     avgtat=avgtat+tat[i];
                     
                 }
                 avgtat=avgtat/pid.length;
                 display=display+"  average TAT is: "+avgtat;
                 System.out.println(display);
                 
                 
                   String display1=" WT of processes: ";
                 for(int i=0;i<wt.length;i++)
                 {
                     display1=display1+"P"+i+"-"+wt[i]+" ";
                     
                 }
                 
                 double avgwt=0;
                 for(int i=0;i<wt.length;i++)
                 {
                     avgwt=avgwt+wt[i];
                     
                 }
                 avgwt=avgwt/pid.length;
                 display1=display1+"  average WT is: "+avgwt;
                 System.out.println(display1);
                 
                 
                  info3.setText(display+"                                      Round Robin                                                            "+display1);
                 
            }


































































































                
                
                
                
                
                
            }
    
    
    
    
    
    
    
    
}






            













            








         




class NPriority extends JPanel
{

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
                
                
                
                 if(d==1)
            {
                boolean check[]=new boolean[pid.length];
                ArrayList<Integer> chart=new ArrayList<Integer>();
                 ArrayList<Integer> track=new ArrayList<Integer>();
                 int limit=0;
                 ArrayList<Integer> cancome=new ArrayList<Integer>();
                 ArrayList<Integer> sequence=new ArrayList<Integer>();



                 for( int i=0;i<pa.length-1;i++)
                {

                    for(int j=0;j<pa.length-1-i;j++)
                    {
                        if(pa[j]>pa[j+1])
                        {
                            int temp1=pa[j];
                            pa[j]=pa[j+1];
                            pa[j+1]=temp1;


                            int temp4 = ba[j];
                            ba[j] = ba[j + 1];
                            ba[j + 1] = temp4;

                            int temp2 = aa[j];
                            aa[j] = aa[j + 1];
                            aa[j + 1] = temp2;


                            int temp3 = pid[j];
                            pid[j] = pid[j + 1];
                            pid[j + 1] = temp3;

                        }
                    }
                }
                 int temp=0;
                while(track.size()!=pid.length)
                {
                    for(int i=0;i<pid.length;i++)
                    {

                        if(aa[i]<=limit && check[pid[i]]==false)

                        {
                            int index=0;

                        int temp2=pa[i];
                        for(int j=0;j<pid.length;j++)
                        {
                            if(pa[j]==temp2)
                            {
                                index=j;



                            }
                        }

                        chart.add(ba[index]);



                            track.add(pid[index]);

                        temp=ba[index];




                            check[pid[i]]=true;




                        }
                    }

                    limit=limit+temp;



                }











                System.out.println(track);



         int et=0;
      g.drawString(""+et, 0, 40);

                double val1 = 0;
                double sum = 0;

                for (int i = 0; i < chart.size(); i++) {
                    sum = sum + chart.get(i);

                }
                for (int i = 0; i < chart.size(); i++)
                {
                    double ratio = chart.get(i) / sum;


                    double length = ratio * this.getWidth();

         Random random=new Random();
         
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fill3DRect((int) val1, 0, (int) length, 30, true);
                        g.setColor(Color.BLACK);
                         
                         int x=(int)(length/2);

                         g.drawString("P"+track.get(i), (int)(val1+x),40); 




                    val1 = val1 + length;



                }
                
for(int i=0;i<chart.size();i++)
                {
                    et=et+chart.get(i);
                    double ratio=et/sum;
                    double length=ratio*this.getWidth();
                    
                    
                    g.drawString(et+" ",(int)length-20, 40);
                    
                    
                    
                }
                
                 
                     
                
                
                int[] ct=new int[pid.length];
                 int[] wt=new int[pid.length];
                 int[] tat=new int[pid.length];
                 for(int i=0;i<ct.length;i++)
                 {  int index=0;
                     for(int j=0;j<track.size();j++)
                     {
                         if(i==track.get(j))
                         {
                             index=j;
                             
                         }
                         
                     }
                     
                     int s=0;
                     for(int k=0;k<=index;k++)
                     {
                         s=s+chart.get(k);
                         
                         
                     }
                     
                     
                 ct[i]=s;
                 
                     
                     
                 }
                 
                 for(int i=0;i<ct.length;i++)
                 {
                     System.out.print(ct[i]+" ");
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     tat[i]=ct[i]-aa[index];
                     
                     
                     
                     
                 }
                 
                 for(int i=0;i<tat.length;i++)
                 {
                     System.out.println(tat[i]+" ");
                 }
                 
                 
                 for(int i=0;i<wt.length;i++)
                 {
                      int index=0;
                     for(int j=0;j<pid.length;j++)
                     {
                         if(i==pid[j])
                         {
                             index=j;
                             
                         }
                     }
                     
                     wt[i]=tat[i]-ba[index];
                 }
                 
                 
                System.out.println("");
                for(int i=0;i<wt.length;i++)
                {
                    System.out.println(wt[i]+" ");
                    
                    
                    
                }
                
                 String display=" TAT of processes: ";
                 for(int i=0;i<tat.length;i++)
                 {
                     display=display+"P"+i+"-"+tat[i]+" ";
                     
                 }
                 
                 double avgtat=0;
                 for(int i=0;i<tat.length;i++)
                 {
                     avgtat=avgtat+tat[i];
                     
                 }
                 avgtat=avgtat/pid.length;
                 display=display+"  average TAT is: "+avgtat;
                 System.out.println(display);
                 
                 
                   String display1=" WT of processes: ";
                 for(int i=0;i<wt.length;i++)
                 {
                     display1=display1+"P"+i+"-"+wt[i]+" ";
                     
                 }
                 
                 double avgwt=0;
                 for(int i=0;i<wt.length;i++)
                 {
                     avgwt=avgwt+wt[i];
                     
                 }
                 avgwt=avgwt/pid.length;
                 display1=display1+"  average WT is: "+avgwt;
                 System.out.println(display1);
                 
                 
                  info4.setText(display+"                                NP-Priority                                                             "+display1);
                 

            }





































            }
 
    
    
    
    
}




class PShortest extends JPanel
{

        @Override
        protected void paintComponent(Graphics g) {
            if(e==1)
            {
            super.paintComponent(g); 
            
            int sum=0;
            int limit=0;
            int d=0;
            
              for (int i = 0; i < aa.length - 1; i++) {

                    for (int j = 0; j < aa.length - 1 - i; j++) {
                        if (aa[j] > aa[j + 1]) {
                            int temp1 = aa[j];
                            aa[j] = aa[j + 1];
                            aa[j + 1] = temp1;

                            int temp2 = ba[j];
                            ba[j] = ba[j + 1];
                            ba[j + 1] = temp2;


                            int temp3 = pid[j];
                            pid[j] = pid[j + 1];
                            pid[j + 1] = temp3;


                        }

                    }

                }
              ArrayList<Integer> chart=new ArrayList<Integer>();
              ArrayList<Integer> track=new ArrayList<Integer>();
              LinkedList<Integer> queue=new LinkedList<Integer>();
              
              
              
              for(int i=0;i<pid.length;i++)
              {
                  sum=sum+ba[i];
                  
              }
              
              int i=0;
              int c=0;
              int mind=0;
              int x=10;
              int w=0;
              int nw=0;
              
              
              while(true)
              {
                  if(limit>sum)
                  {
                      break;
                      
                      
                  }
                  
                  int min=Integer.MAX_VALUE;
                  limit=limit+1;
                  nw=nw+1;
                  ba[i]=ba[i]-1;
                  if(ba[i]==0)
                  {
                      ba[i]=1000;
                      
                  
              }
                  
                  for(int k=0;k<pid.length;k++)
                  {
                      if(aa[k]<=limit)
                      {
                          queue.add(pid[k]);
                          
                          
                          c++;
                          
                      }
                          
                  }
                  for(int k=0;k<c;k++)
                  {
                      int s=queue.get(k);
                      int index=0;
                      for(int j=0;j<pid.length;j++)
                      {
                          if(s==pid[j])
                          {
                              index=j;
                              
                          }
                      }
                      
                      if(ba[index]<min)
                      {
                          min=ba[index];
                          mind=index;
                          
                      }
                      
                      
                  }
                  
                  if(ba[mind]<ba[i])
                  {
                      i=mind;
                       
                  
                    w=(((getWidth()-20)*nw)/sum);
                    g.drawRect(x, 0, this.getWidth()*w, 35);  
                    chart.add(this.getWidth()*w);
                    
                    
                 nw=0;
                    x=x+w;
                  }
                  
                  
                  
                  
              
              
              }
              g.drawLine(x, 0, x, 35);
              queue.removeAll(queue);
              
              c=0;
                System.out.println(track);
                
              
              
              
              
              
              
            
            
            
            
            
        }
    
        }
    
    
    
}
}



































           












      














