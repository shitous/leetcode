public class FileSystem {
    class Dir {
        HashMap<String, String> files = new HashMap<>();
        HashMap<String, Dir> dirs = new HashMap<>();
    }
    Dir root;
    public FileSystem() {
        root = new Dir();
    }
    
    public List<String> ls(String path) {
        Dir t = root;
        List<String> list = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i= 1; i < d.length -1; i ++) {
                t = t.dirs.get(d[i]);
            }
            if (t.files.containsKey(d[d.length-1])) {
                list.add(d[d.length-1]);
                return list;
            }
            else {
                t = t.dirs.get(d[d.length-1]);
            }
        }
        list.addAll(new ArrayList<>(t.files.keySet()));
        list.addAll(new ArrayList<>(t.dirs.keySet()));
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        Dir t = root; 
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.dirs.containsKey(d[i])) {
                t.dirs.put(d[i], new Dir());
            }
            t = t.dirs.get(d[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        Dir t = root; 
        String[] d = filePath.split("/");
        for (int i = 1; i < d.length-1; i++) {
            t = t.dirs.get(d[i]);
        }
        t.files.put(d[d.length-1], t.files.getOrDefault(d[d.length-1],"") + content);
    }
    
    public String readContentFromFile(String filePath) {
        Dir t = root; 
        String[] d = filePath.split("/");
        for (int i = 1; i<d.length-1; i++) {
            t = t.dirs.get(d[i]);
        }
        return t.files.get(d[d.length-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
