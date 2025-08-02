global.TextEncoder = require('util').TextEncoder;
if (typeof global.ReadableStream === 'undefined') {
  const { ReadableStream } = require('stream/web');
  global.ReadableStream = ReadableStream;
}
const { configure } = require('enzyme');
const Adapter = require('enzyme-adapter-react-16');

configure({ adapter: new Adapter() });