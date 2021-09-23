var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":17,"id":66,"methods":[{"el":16,"sc":5,"sl":14}],"name":"MailServer","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":14}],"name":"[2] Brest","pass":true,"statements":[]},"test_2":{"methods":[{"sl":14}],"name":"[1] Minsk","pass":true,"statements":[]},"test_4":{"methods":[{"sl":14}],"name":"testSendMessage","pass":true,"statements":[]},"test_5":{"methods":[{"sl":14}],"name":"testSendMessage()","pass":true,"statements":[]},"test_6":{"methods":[{"sl":14}],"name":"[3] Vitebsk","pass":true,"statements":[]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [6, 4, 5, 0, 2], [], [], []]
