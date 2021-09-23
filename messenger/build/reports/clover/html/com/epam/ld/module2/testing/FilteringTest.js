var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":72,"id":67,"methods":[{"el":43,"sc":5,"sl":33},{"el":58,"sc":5,"sl":45},{"el":70,"sc":5,"sl":61}],"name":"FilteringTest","sl":24}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_3":{"methods":[{"sl":45}],"name":"givenTestMethodWithTempDirectory","pass":true,"statements":[{"sl":50},{"sl":52},{"sl":53},{"sl":55}]},"test_4":{"methods":[{"sl":61}],"name":"testSendMessage","pass":true,"statements":[{"sl":65},{"sl":66},{"sl":68},{"sl":69}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [3], [], [], [], [], [3], [], [3], [3], [], [3], [], [], [], [], [], [4], [], [], [], [4], [4], [], [4], [4], [], [], [], [], [], [], []]
