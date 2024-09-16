class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, TreeNode> nodeMap = new HashMap<>();
        Set<String> childSet = new HashSet<>();
        for (List<String> r: regions) {
            TreeNode parent;
            if (nodeMap.containsKey(r.get(0))) {
                parent = nodeMap.get(r.get(0));
            } else {
                parent = new TreeNode(r.get(0));
                nodeMap.put(r.get(0), parent);
            }

            for (int i = 1; i < r.size(); i++) {
                TreeNode child;
                if (nodeMap.containsKey(r.get(i))) {
                    child = nodeMap.get(r.get(i));
                } else {
                    child = new TreeNode(r.get(i));
                    nodeMap.put(r.get(i), child);
                }
                parent.addChild(child);
                childSet.add(r.get(i));
            }
        }

        TreeNode root = null;
        for (String r: nodeMap.keySet()) {
            if (!childSet.contains(r)) {
                root = nodeMap.get(r);
            }
        }

        TreeNode lca = findLCA(root, region1, region2);
        return lca.val;
    }

    private TreeNode findLCA(TreeNode root, String region1, String region2) {
        if (root == null) {
            return null;
        }
        if (region1.equals(root.val) || region2.equals(root.val)) {
            return root;
        }

        TreeNode lca = null;
        int notNullCount = 0;
        for (TreeNode child: root.children) {
            TreeNode result = findLCA(child, region1, region2);
            if (result != null) {
                lca = result;
                notNullCount++;
            }
        }
        if (notNullCount == 1) {
            return lca;
        } if (notNullCount == 0) {
            return null;
        } else {
            return root;
        }
    }

    class TreeNode {
        String val;
        List<TreeNode> children;

        TreeNode() {
            this.val = "";
            this.children = new ArrayList<>();
        }

        TreeNode(String val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeNode child) {
            this.children.add(child);
        }
    }
}