class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
    }

    @BeforeEachvoid
    setUp() {
        driver = new ChromeDriver();
    }

    @AfterEachvoid
    tearDown() {
        driver.quit();
        driver = null;
    }

    @Testvoid
    shouldTestSomething() {
        throw new UnsupportedOperationException();