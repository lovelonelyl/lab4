public static Node walkTheTree(Node start, int steps){         boolean fromright=true;         Node shuttle=start, holder;         if (shuttle.right!=null){             shuttle=shuttle.right;             while (shuttle.left!=null) shuttle=shuttle.left;             fromright=false; 
        } 
        int counter=0;         do{             while (true){ 
                if (!fromright && ++counter==steps) return shuttle;                 if (!fromright && shuttle.right!=null){ 
                        shuttle=shuttle.right;                         break; 
                    } 
                holder=shuttle; 
                shuttle=shuttle.parent;                 fromright=(holder==shuttle.right); 
            } 
            while (shuttle.left!=null) shuttle=shuttle.left; 
        }while (true); 
    } 
static void parentPostOrder(Node top){         boolean fromright=false;         Node shuttle=top, holder;         while(true){             while (fromright){                 shuttle.treatment();                 if (shuttle==top) return;                 holder=shuttle;                 shuttle=shuttle.parent;                 fromright=shuttle.right==holder;                 if (!fromright && shuttle.right!=null) shuttle=shuttle.right;                 else fromright=true; 
            } 
            while (shuttle.left!=null) shuttle=shuttle.left;             if (shuttle.right!=null) shuttle=shuttle.right;             else fromright=true; 
        } 
    } 
static void contPostOrder(Node top){          Stack<Node> stack = new Stack<> ();           while (top!=null || !stack.empty()){              if (!stack.empty()){                  top=stack.pop(); 
                 if (!stack.empty() && top.right==stack.lastElement()){ 
                     top=stack.pop(); 
                 }else{                      top.treatment();                      top=null; 
                 } 
             } 
             while (top!=null){                  stack.push(top);                  if (top.right!=null){                      stack.push(top.right);                      stack.push(top); 
                 } 
                 top=top.left; 
             } 
         } 
    } 
 
static void contInOrder(Node top){          Stack<Node> stack = new Stack<> ();           while (top!=null || !stack.empty()){              if (!stack.empty()){                  top=stack.pop();                  top.treatment();                  if (top.right!=null) top=top.right;                  else top=null; 
             } 
             while (top!=null){                  stack.push(top);                  top=top.left; 
             } 
         } 
    } 
static void contPreOrder(Node top){          Stack<Node> stack = new Stack<> ();           while (top!=null || !stack.empty()){              if (!stack.empty()){                  top=stack.pop(); 
             } 
             while (top!=null){                  top.treatment();                  if (top.right!=null) stack.push(top.right);                  top=top.left; 
             } 
         } 
    } 
static void contLevelOrder(Node top){ 
        Queue<Node> queue=new LinkedList<> (); 
        do{             top.treatment();             if (top.left!=null) queue.add(top.left);             if (top.right!=null) queue.add(top.right);             if (!queue.isEmpty()) top=queue.poll(); 
        }while (!queue.isEmpty()); 
    } 
