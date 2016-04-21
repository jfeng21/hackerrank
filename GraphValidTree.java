public class GraphValidTree{

 public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        
        boolean isValid = validTree(5, edges);
        System.out.println(isValid);
    }
    
    static boolean validTree(int n, int[][] edges) {  
        if(n-1 != edges.length){
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++){
            if(uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1]))   //detect cycle
            return false;
            uf.union(edges[i][0], edges[i][1]);   //add to same father
        }
        return true;
        
    }

}

class UnionFind{
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    UnionFind(int n){
        for(int i = 0; i< n; i++){
            father.put(i,i);
        }
    }
        int compressed_find(int x){
            int parent = father.get(x);
            while(parent != father.get(parent)){
                parent = father.get(parent);
            }
            int tmp = -1;
            int fa = father.get(x);
            while(fa != father.get(fa)){
                tmp = father.get(fa);
                father.put(fa, parent);
                fa = tmp;
            }
            return parent;
        }
        
        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
            father.put(fa_x, fa_y);
        }
    }
