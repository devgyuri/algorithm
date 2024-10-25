class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        FolderTreeNode root = new FolderTreeNode("");

        for (String path: folder) {
            String parsings = path.split("/");
             
        }

        return ans;
    }

    class FolderTreeNode {
        private String name;
        private FolderTreeNode child;

        FolderTreeNode(String name, FolderTreeNode child) {
            this.name = name;
            this.child = child;
        }

        FolderTreeNode(String name) {
            this.name = name;
            this.child = null;
        }
    }
}