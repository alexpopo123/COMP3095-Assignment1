package gbc.ca.comp3095assignment1.controller;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {
        // Define behavior for your mocked service methods
    }

    @Test
    public void testCreateUser() throws Exception {
        // Create a sample user object to be sent in the request
        User userToCreate = new User();
        userToCreate.setUsername("testuser");
        userToCreate.setEmail("testuser@example.com");

        // Create a sample user object to be returned by the mocked service
        User createdUser = new User();
        createdUser.setId(1L);
        createdUser.setUsername("testuser");
        createdUser.setEmail("testuser@example.com");

        // Mock the UserService behavior
        when(userService.createUser(Mockito.any(User.class))).thenReturn(createdUser);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userToCreate)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.username", is("testuser")))
                .andExpect(jsonPath("$.email", is("testuser@example.com")));
    }

    // Utility method to convert an object to JSON
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}