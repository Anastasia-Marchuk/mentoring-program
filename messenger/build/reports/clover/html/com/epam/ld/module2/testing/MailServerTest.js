var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":176,"id":82,"methods":[{"el":46,"sc":5,"sl":42},{"el":51,"sc":5,"sl":48},{"el":56,"sc":5,"sl":53},{"el":61,"sc":5,"sl":58},{"el":78,"sc":5,"sl":64},{"el":102,"sc":5,"sl":80},{"el":117,"sc":5,"sl":105},{"el":128,"sc":5,"sl":121},{"el":140,"sc":5,"sl":131},{"el":162,"sc":5,"sl":154},{"el":174,"sc":5,"sl":164}],"name":"MailServerTest","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":64}],"name":"[2] Brest","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":71},{"sl":75},{"sl":76}]},"test_1":{"methods":[{"sl":154}],"name":"This is Exception with Assertation","pass":true,"statements":[{"sl":158},{"sl":159},{"sl":160}]},"test_2":{"methods":[{"sl":64}],"name":"[1] Minsk","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":71},{"sl":75},{"sl":76}]},"test_5":{"methods":[{"sl":121}],"name":"testSendMessage()","pass":true,"statements":[{"sl":124},{"sl":125},{"sl":126},{"sl":127}]},"test_6":{"methods":[{"sl":64}],"name":"[3] Vitebsk","pass":true,"statements":[{"sl":68},{"sl":69},{"sl":71},{"sl":75},{"sl":76}]},"test_7":{"methods":[{"sl":105}],"name":"This is TemporaryFolder rule","pass":true,"statements":[{"sl":109},{"sl":111},{"sl":112},{"sl":114}]},"test_8":{"methods":[{"sl":80}],"name":"testDinamics","pass":true,"statements":[{"sl":84},{"sl":85},{"sl":86},{"sl":88},{"sl":89},{"sl":92},{"sl":93},{"sl":94},{"sl":97},{"sl":98},{"sl":101}]},"test_9":{"methods":[{"sl":164}],"name":"This is Exception with Assertation2","pass":true,"statements":[{"sl":167},{"sl":168},{"sl":169},{"sl":170},{"sl":172}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [6, 0, 2], [], [], [], [6, 0, 2], [6, 0, 2], [], [6, 0, 2], [], [], [], [6, 0, 2], [6, 0, 2], [], [], [], [8], [], [], [], [8], [8], [8], [], [8], [8], [], [], [8], [8], [8], [], [], [8], [8], [], [], [8], [], [], [], [7], [], [], [], [7], [], [7], [7], [], [7], [], [], [], [], [], [], [5], [], [], [5], [5], [5], [5], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [1], [], [], [], [1], [1], [1], [], [], [], [9], [], [], [9], [9], [9], [9], [], [9], [], [], [], []]
