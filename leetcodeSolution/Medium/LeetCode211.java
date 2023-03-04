 class LeetCode211 {
        
        Set<String> store;

        public WordDictionary() {
            store = new LinkedHashSet<>();
        }

        public void addWord(String word) {
            store.add(word);
        }

        public boolean search(String word) {

            if(word.indexOf('.')==-1){
                return store.contains(word);
            }
            for (String x : store) {
                    int count = 0;
                    if (x.length() == word.length()) {
                        for (int j = 0; j < word.length(); j++) {
                            if (x.equals(word)) {
                                return true;
                            }
                            if (word.charAt(j) == '.') {
                                count++;
                            } else {
                                if (word.charAt(j) == x.charAt(j)) {
                                    count++;
                                } else if (word.charAt(j) != x.charAt(j)) {
                                    break;
                                }
                            }
                        }
                        if (count == word.length()) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            return false;
        }
    }
