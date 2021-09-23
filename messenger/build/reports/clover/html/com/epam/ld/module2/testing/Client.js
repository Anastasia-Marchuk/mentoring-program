var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":32,"id":59,"methods":[{"el":9,"sc":5,"sl":9},{"el":13,"sc":5,"sl":11},{"el":22,"sc":5,"sl":20},{"el":31,"sc":5,"sl":29}],"name":"Client","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":9},{"sl":20},{"sl":29}],"name":"[2] Brest","pass":true,"statements":[{"sl":21},{"sl":30}]},"test_2":{"methods":[{"sl":9},{"sl":20},{"sl":29}],"name":"[1] Minsk","pass":true,"statements":[{"sl":21},{"sl":30}]},"test_4":{"methods":[{"sl":9},{"sl":20},{"sl":29}],"name":"testSendMessage","pass":true,"statements":[{"sl":21},{"sl":30}]},"test_5":{"methods":[{"sl":9},{"sl":20},{"sl":29}],"name":"testSendMessage()","pass":true,"statements":[{"sl":21},{"sl":30}]},"test_6":{"methods":[{"sl":9},{"sl":20},{"sl":29}],"name":"[3] Vitebsk","pass":true,"statements":[{"sl":21},{"sl":30}]},"test_8":{"methods":[{"sl":9},{"sl":29}],"name":"testDinamics","pass":true,"statements":[{"sl":30}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [6, 4, 8, 5, 0, 2], [], [], [], [], [], [], [], [], [], [], [6, 4, 5, 0, 2], [6, 4, 5, 0, 2], [], [], [], [], [], [], [], [6, 4, 8, 5, 0, 2], [6, 4, 8, 5, 0, 2], [], []]
