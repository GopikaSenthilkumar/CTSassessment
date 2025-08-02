const axios = require('axios');
const GitClient = require('./GitClient').default;

jest.mock('axios');
describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const dummyRepos = [{ name: 'repo1' }, { name: 'repo2' }];
    axios.get.mockResolvedValue({ data: dummyRepos });
    const gitClient = new GitClient();
    const repos = await gitClient.getRepositories('techiesyed');

    expect(repos).toEqual(['repo1', 'repo2']);
  });
});